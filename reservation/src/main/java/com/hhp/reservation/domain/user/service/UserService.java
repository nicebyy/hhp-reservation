package com.hhp.reservation.domain.user.service;

import com.hhp.reservation.common.enums.ResponseCodeEnum;
import com.hhp.reservation.common.exception.BusinessException;
import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(String userName){
        userRepository.saveUser(userName);
    }

    public User findUser(Long userId){
        return userRepository
                .findUserById(userId)
                .orElseThrow(() -> new BusinessException(ResponseCodeEnum.USER_NOT_FOUNT));
    }

    public User findUserToCreateToken(Long userId){
        return userRepository
                .loadUserById(userId)
                .orElseThrow(() -> new BusinessException(ResponseCodeEnum.USER_NOT_FOUNT));
    }
}
