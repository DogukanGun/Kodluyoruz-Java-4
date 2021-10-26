package com.kodluyoruz.dogukanaligundoganhm4.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {

    private Integer id;
    private Integer userId;
}
