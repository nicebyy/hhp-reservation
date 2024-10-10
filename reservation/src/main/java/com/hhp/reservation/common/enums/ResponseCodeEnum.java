package com.hhp.reservation.common.enums;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    SUCCESS(0x0000, "success"),
    FAILED(-0x0001, "failed"),
    ERROR(-0x0002,"error"),

    VALIDATION_ERROR(-0x1001, "잘못된 인자 입니다."),

    USER_NOT_FOUNT(-0x2001,"해당 유저를 찾을 수 없습니다."),
    TOKEN_NOT_VALID(-0x2002,"토큰이 유효하지 않습니다."),

    NOT_VALID_CONCERT(-0x3001,"해당 콘서트를 찾을 수 없습니다."),
    NOT_VALID_CONCERT_SCHEDULE(-0x3002,"해당 날짜의 콘서트를 찾을 수 없습니다."),
    NOT_VALID_SEAT(-0x3003,"해당 좌석을 찾을 수 없습니다."),
    SEAT_ALREADY_OCCUPIED(-0x3004,"이미 예약된 좌석입니다."),
    NOT_VALID_RESERVATION(-0x3005,"유효하지 않는 예약 정보 입니다."),
    TEMP_RESERVATION_HAS_EXPIRED(-0x3006,"결제 시간이 초과 하였습니다."),


    NOT_ENOUGH_POINT(-0x4001,"결제 금액이 부족합니다."),
    ;
    private final int code;

    private final String message;

    ResponseCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}