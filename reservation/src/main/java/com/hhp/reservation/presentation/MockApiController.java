package com.hhp.reservation.presentation;

import com.hhp.reservation.common.api.ApiResponse;
import com.hhp.reservation.common.enums.ResponseCodeEnum;
import com.hhp.reservation.presentation.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping ("/mock")
public class MockApiController {

    /**
     * 공통적으로 사용할 UUID : "f0efca77-833a-43e0-b577-937d25ecf9cf"
     */
    @GetMapping("/token/{userId}")
    public ResponseEntity<ApiResponse> issueToken(
            @PathVariable Long userId
    ) {
        if (userId == 999) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.USER_NOT_FOUNT));
        }
        return ResponseEntity.ok(ApiResponse.success(
                UserTokenResponse.builder()
                        .token(UUID.randomUUID())
                        .waitCount(10)
                        .waitTime("00:05:00")
                        .build()
        ));
    }

    @GetMapping("/concert")
    public ResponseEntity<ApiResponse> findAllConcert(
            @RequestBody String token
    ) {
        if (!checkValidToken(token)) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }
        return ResponseEntity.ok(ApiResponse.success(
                List.of(
                        ConcertResponse.builder()
                                .concertId(1L)
                                .concertName("콘서트 1")
                                .build(),
                        ConcertResponse.builder()
                                .concertId(2L)
                                .concertName("콘서트 2")
                                .build()
                )
        ));
    }

    @GetMapping("/concert/schedule")
    public ResponseEntity<ApiResponse> searchConcertSchedule(
            @RequestBody SearchConcertScheduleRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        if (request.getConcertId() != 1L) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.NOT_VALID_CONCERT));
        }

        return ResponseEntity.ok(ApiResponse.success(
                List.of(
                        SearchConcertScheduleResponse.builder()
                                .concertId(request.getConcertId())
                                .concertName("콘서트 1")
                                .scheduleId(1L)
                                .startTime("2024-12-14:12:00:00")
                                .reservationTime("2024-10-14:12:00:00")
                                .build(),
                        SearchConcertScheduleResponse.builder()
                                .concertId(request.getConcertId())
                                .concertName("콘서트 1")
                                .scheduleId(2L)
                                .startTime("2024-12-15:12:00:00")
                                .reservationTime("2024-10-14:12:00:00")
                                .build()
                )
        ));
    }

    @GetMapping("/concert/schedule/seat")
    public ResponseEntity<ApiResponse> searchConcertScheduleSeat(
            @RequestBody SearchConcertSeatRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        if (request.getScheduleId() != 1L) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.NOT_VALID_CONCERT_SCHEDULE));
        }

        return ResponseEntity.ok(ApiResponse.success(
                List.of(
                        SearchConcertSeatResponse.builder()
                                .seatId(1L)
                                .seatPrice(20000L)
                                .seatPosition("A1")
                                .build(),
                        SearchConcertSeatResponse.builder()
                                .seatId(2L)
                                .seatPrice(30000L)
                                .seatPosition("A2")
                                .build()
                )
        ));
    }

    @PostMapping("/concert/schedule/seat")
    public ResponseEntity<ApiResponse> reservationConcertSeat(
            @RequestBody ReservationConcertSeatRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        if (request.getSeatId() == 9999L) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.NOT_VALID_SEAT));
        } else if (request.getSeatId() == 1L) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.SEAT_ALREADY_OCCUPIED));
        }

        return ResponseEntity.ok(ApiResponse.success(
                ReservationConcertSeatResponse.builder()
                        .reservationId(1L)
                        .paymentLimitTime("2024-10-14:12:00:05")
                        .build()
        ));
    }

    @PostMapping("/point")
    public ResponseEntity<ApiResponse> chargeUserPoint(
            @RequestBody ChargePointRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        return ResponseEntity.ok(ApiResponse.success(
                ChargePointResponse.builder()
                        .balance(request.getAmount())
                        .build()
        ));
    }

    @GetMapping("/point")
    public ResponseEntity<ApiResponse> searchUserPoint(
            @RequestBody SearchPointRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        return ResponseEntity.ok(ApiResponse.success(
                SearchPointResponse.builder()
                        .balance(2000L)
                        .build()
        ));
    }

    @PostMapping("/reservation/pay")
    public ResponseEntity<ApiResponse> payReservation(
            @RequestBody PayReservationRequest request
    ) {
        if (!checkValidToken(request.getToken())) {
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TOKEN_NOT_VALID));
        }

        if(request.getReservationId()==1L){
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.NOT_ENOUGH_POINT));
        }else if(request.getReservationId()==999L){
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.NOT_VALID_RESERVATION));
        }else if(request.getReservationId()==998L){
            return ResponseEntity.ok(ApiResponse.failed(ResponseCodeEnum.TEMP_RESERVATION_HAS_EXPIRED));
        }

        return ResponseEntity.ok(ApiResponse.success(
                PayReservationResponse.builder()
                        .userName("홍길동")
                        .balance(22000L)
                        .reservationId(2L)
                        .paymentId(1L)
                        .paymentDate("2024-10-14:12:00:03")
                        .build()
        ));
    }

    private static boolean checkValidToken(String token) {
        return "f0efca77-833a-43e0-b577-937d25ecf9cf".equals((token));
    }
}
