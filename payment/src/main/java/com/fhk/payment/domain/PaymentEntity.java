package com.fhk.payment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    private Long id;





}
