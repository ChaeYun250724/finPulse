package com.fhk.payment.controller;

import com.fhk.payment.dto.PayReq;
import com.fhk.payment.dto.PayRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @PostMapping
    public ResponseEntity<PayRes> pay(@RequestBody PayReq payReq) {
        return null;
    }

}
