package com.fhk.payment.api;

import com.fhk.payment.domain.PaymentEntity;
import com.fhk.payment.dto.ConfirmReq;
import com.fhk.payment.dto.ConfirmRes;
import com.fhk.payment.dto.SearchReq;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class TossClient {

        private final WebClient webClient;

        public TossClient(@Value("${tosspayments.secret-key}") String secretKey){
            this.webClient = WebClient.builder()
                    .baseUrl("https://sandbox.tosspayments.com")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .defaultHeaders(h -> h.setBasicAuth(secretKey, "")) // Toss는 비밀번호 빈 문자열
                    .build();
        }

        public PaymentEntity confirm(ConfirmReq confirmReq) {

            Mono<ConfirmRes> response = webClient.post()
                    .uri("/v1/payments/confirm")
                    .bodyValue(confirmReq)
                    .retrieve()
                    .bodyToMono(ConfirmRes.class);

            return null;
        }

        public PaymentEntity search(SearchReq searchReq) {
            return null;
        }

        public PaymentEntity cancel(SearchReq searchReq) {
            return null;
        }

        public PaymentEntity virtual(SearchReq searchReq) {
            return null;
        }
}

// --- 헤더의 인증객체 ---
//Basic Auth → Authorization: Basic <Base64(user:pass)>
//Bearer Token → Authorization: Bearer <token>
//setBasicAuth()나 setBearerAuth()를 쓰는 이유는 자동으로 Authorization 헤더를 올바른 형식으로 만들어 주기 때문
//단순히 header("Authorization", ...) 직접 넣어도 되지만, 인코딩 등을 수동으로 처리해야 함


