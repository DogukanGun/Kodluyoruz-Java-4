package com.kodluyoruz.dogukanaligundoganhm4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {
    private Integer id;

    private String name;

    private Integer basketId;

    private int price;

    private boolean madePurchase;
}
