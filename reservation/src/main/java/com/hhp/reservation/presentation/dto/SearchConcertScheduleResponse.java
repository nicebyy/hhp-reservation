package com.hhp.reservation.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchConcertScheduleResponse {

    Long concertId;
    String concertName;
    Long scheduleId;
    String startTime;
    String reservationTime;
}
