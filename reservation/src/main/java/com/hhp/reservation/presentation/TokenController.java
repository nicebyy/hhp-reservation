package com.hhp.reservation.presentation;

import com.hhp.reservation.application.IssueTokenUseCase;
import com.hhp.reservation.common.api.ApiResponse;
import com.hhp.reservation.domain.user.entity.Token;
import com.hhp.reservation.presentation.dto.UserTokenResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final IssueTokenUseCase issueTokenUseCase;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> issueUserToken(
            @PathVariable("userId") Long userId
    ){
        UserTokenResponse response = issueTokenUseCase.createUserToken(userId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
