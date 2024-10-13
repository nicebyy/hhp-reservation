package com.hhp.reservation.domain.user.repository;

import com.hhp.reservation.domain.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository{

    public User saveUser(String userName);

    public Optional<User> findUserById(Long userId);

    public Optional<User> loadUserById(Long userId);
}
