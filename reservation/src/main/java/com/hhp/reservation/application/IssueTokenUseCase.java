package com.hhp.reservation.application;

import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.service.QueueService;
import com.hhp.reservation.domain.user.service.UserService;
import com.hhp.reservation.presentation.dto.UserTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class IssueTokenUseCase {
    private final UserService userService;
    private final QueueService queueService;

    @Transactional
    public UserTokenResponse createUserToken(Long userId){

        User user = userService.findUserToCreateToken(userId);
        Token token = queueService.issueToken(user);

        return UserTokenResponse.builder()
                .token(token.getTokenId())
                .waitCount(token.getWaitCount())
                .tokenStatus(token.getTokenStatus())
                .waitTime(token.getWaitTime())
                .userName(user.getUserName())
                .build();
    }
}
