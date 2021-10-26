package com.kodluyoruz.dogukanaligundoganhm4.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreateOrderRequest {

    private Integer userId;
    private Integer basketId;
}
