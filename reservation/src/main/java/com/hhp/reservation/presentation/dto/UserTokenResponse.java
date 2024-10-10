package com.hhp.reservation.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenResponse {

    UUID token;
    String waitTime;
    Integer waitCount;
}
