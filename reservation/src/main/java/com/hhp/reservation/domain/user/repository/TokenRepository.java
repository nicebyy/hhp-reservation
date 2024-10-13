package com.hhp.reservation.domain.user.repository;

import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenRepository {

    public Token saveToken(Token token);
    public Optional<Token> findLastToken(User user);
    Integer countActiveToken();
    Integer countWaitingToken(LocalDateTime localDateTime);
}
