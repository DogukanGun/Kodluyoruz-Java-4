package com.kodluyoruz.dogukanaligundoganhm4.model.dto;

import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketItemDto {

    private Integer id;

    private Integer productId;

    private int quantity;

    private Integer basketId;

}
