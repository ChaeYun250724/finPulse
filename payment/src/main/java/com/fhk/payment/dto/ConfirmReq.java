package com.fhk.payment.dto;

import lombok.Getter;

@Getter
public class ConfirmReq {

    private String paymentKey;  //결제의 키값
    private String orderId; //주문번호
    private int amount; //결제할 금액


}
