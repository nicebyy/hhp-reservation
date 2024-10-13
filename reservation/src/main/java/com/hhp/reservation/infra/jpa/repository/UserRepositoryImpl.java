package com.hhp.reservation.infra.jpa.repository;

import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User saveUser(String userName) {
        return userJpaRepository.save(new User(userName));
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userJpaRepository.findById(userId);
    }

    @Override
    public Optional<User> loadUserById(Long userId) {
        return userJpaRepository.findUserByUserId(userId);
    }
}
