package com.bookMyShow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refNo;
    private Date paymentTime;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentGateWayProvider paymentGateWayProvider;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
}
