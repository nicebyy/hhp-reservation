package com.hhp.reservation.infra.jpa.repository;

import com.hhp.reservation.domain.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Optional<User> findUserByUserId(Long userId);
}
