package com.hhp.reservation.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayReservationResponse {

    String userName;
    Long reservationId;
    Long paymentId;
    Long balance;
    String paymentDate;
}
