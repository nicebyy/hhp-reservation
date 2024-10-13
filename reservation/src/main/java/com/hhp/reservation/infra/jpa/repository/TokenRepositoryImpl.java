package com.hhp.reservation.infra.jpa.repository;

import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.TokenStatus;
import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private final TokenJpaRepository tokenJpaRepository;

    @Override
    public Token saveToken(Token token) {
        return tokenJpaRepository.save(token);
    }

    @Override
    public Optional<Token> findLastToken(User user) {
        Sort sortCond = Sort.by("createDate").descending();
        return tokenJpaRepository.findTopByUser(user,sortCond);
    }

    @Override
    public Integer countActiveToken() {
        return tokenJpaRepository.countTokenByTokenStatus(TokenStatus.ACTIVE);
    }

    @Override
    public Integer countWaitingToken(LocalDateTime localDateTime) {
        return tokenJpaRepository.countTokenByTokenStatusAndCreateDateBefore(TokenStatus.WAITING, localDateTime);
    }
}
