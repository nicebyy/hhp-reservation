package com.hhp.reservation.domain.user.service;

import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.domain.user.entity.TokenStatus;
import com.hhp.reservation.domain.user.entity.User;
import com.hhp.reservation.domain.user.repository.TokenRepository;
import com.hhp.reservation.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * QueueService 단위 테스트
 */

@ExtendWith(MockitoExtension.class)
class QueueServiceUnitTest {

    @InjectMocks
    private QueueService queueService;

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("유저로 토큰을 발급 한다.")
    void issueToken_Success() {

        //given
        Long userId = 1L;
        String userName = "홍길동";
        User user = new User(userName);
        setField(user,"userId",userId);

        Long TOKEN_ACTIVE_DURATION = 5L;
        TokenStatus waitingStatus = TokenStatus.WAITING;
        LocalDateTime expireTime = LocalDateTime.now().plusMinutes(TOKEN_ACTIVE_DURATION);
        Token token = new Token(user, waitingStatus);

        given(tokenRepository.saveToken(any(Token.class))).willReturn(token); // tokenRepository 동작 모의

        //when
        Token result = queueService.issueToken(user);

        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(token);
        assertThat(result.getExpiredDate()).isEqualTo(token.getExpiredDate());
    }
}