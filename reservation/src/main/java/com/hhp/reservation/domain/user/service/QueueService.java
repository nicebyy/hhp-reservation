package com.hhp.reservation.domain.user.service;

import com.hhp.reservation.common.enums.ResponseCodeEnum;
import com.hhp.reservation.common.exception.BusinessException;
import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.TokenStatus;
import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.repository.TokenRepository;
import com.hhp.reservation.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueueService {

    public static final long TOKEN_ACTIVE_DURATION = 1000 * 60 * 5; // ACTIVE 활성화 시간
    public static final long QUEUE_PROCESS_TIME = 1000 * 60; // 큐가 한번에 처리 하는 시간은 1분
    public static final long QUEUE_PROCESS_COUNT = 5; // 큐가 한번에 처리하는 토큰 수
    public static final long MAX_QUEUE_CAPACITY = 30; // 큐의 최대용량

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    /**
     * 토큰 발급 로직
     */
    @Transactional
    public Token issueToken(User user){

        Optional<Token> lastToken = findLastToken(user);

        if(lastToken.isPresent()){
            Token existToken = lastToken.get();
            Integer waitingTokenCount = getWaitingTokenCount(existToken.getCreateDate());
            long expectedMillis = (waitingTokenCount / QUEUE_PROCESS_COUNT) * QUEUE_PROCESS_TIME + QUEUE_PROCESS_TIME;
            String waitTimeString = toWaitTimeString(expectedMillis);
            existToken.setWaitInfo(waitingTokenCount,waitTimeString);
            return existToken;
        }

        Token savedToken = tokenRepository.saveToken(Token.builder()
                .user(user)
                .tokenStatus(TokenStatus.WAITING)
                .build()
        );
        Integer waitingTokenCount = getWaitingTokenCount(savedToken.getCreateDate());
        long expectedMillis = (waitingTokenCount / QUEUE_PROCESS_COUNT) * QUEUE_PROCESS_TIME + QUEUE_PROCESS_TIME;
        String waitTimeString = toWaitTimeString(expectedMillis);
        savedToken.setWaitInfo(waitingTokenCount,waitTimeString);
        return savedToken;
    }

    private static String toWaitTimeString(long expectedMillis) {
        long seconds = expectedMillis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;

        String hoursString = hours >= 10 ? Long.toString(hours) : "0"+hours;
        String minutesString = minutes >= 10 ? Long.toString(minutes) : "0"+minutes;
        String secondsString = seconds >= 10 ? Long.toString(seconds) : "0"+seconds;

        return hoursString+":"+minutesString+":"+secondsString;
    }

    public Optional<Token> findLastToken(User user){
        return tokenRepository.findLastToken(user);
    }

    public Integer getActiveTokenCount(){
        return tokenRepository.countActiveToken();
    }

    public Integer getWaitingTokenCount(LocalDateTime criteria){
        return tokenRepository.countWaitingToken(criteria);
    }
}
