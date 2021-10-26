package com.kodluyoruz.dogukanaligundoganhm4.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
    private Integer userId;
    private String name;
    private Integer basketId;
    private Boolean isCanceled;

}
