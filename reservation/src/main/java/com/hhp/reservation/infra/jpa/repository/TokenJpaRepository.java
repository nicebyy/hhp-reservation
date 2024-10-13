package com.hhp.reservation.infra.jpa.repository;

import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.TokenStatus;
import com.hhp.reservation.domain.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenJpaRepository extends JpaRepository<Token,Long> {

    @EntityGraph(attributePaths = {"user"})
    public Optional<Token> findTopByUser(User user, Sort sort);

    public Integer countTokenByTokenStatus(TokenStatus tokenStatus);

    public Integer countTokenByTokenStatusAndCreateDateBefore(TokenStatus tokenStatus, LocalDateTime createDate);

}
