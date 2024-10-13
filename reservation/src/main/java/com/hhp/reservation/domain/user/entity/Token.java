package com.hhp.reservation.domain.user.entity;

import com.hhp.reservation.infra.jpa.config.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "token")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tokenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime expiredDate;

    @Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @Transient
    private Integer waitCount;

    @Transient
    private String waitTime;

    @Builder
    public Token(User user, TokenStatus tokenStatus){
        this.user = user;
        this.tokenStatus = tokenStatus;
    }

    public Token setWaitInfo(Integer waitCount, String waitTime){
        this.waitCount = waitCount;
        this.waitTime = waitTime;
        return this;
    }

    public Token activeToken(LocalDateTime expiredDate){
        this.expiredDate = expiredDate;
        this.tokenStatus = TokenStatus.ACTIVE;
        return this;
    }
}
