package com.hhp.reservation.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchConcertSeatRequest {
    String token;
    Long scheduleId;
    String dateCond;
}
