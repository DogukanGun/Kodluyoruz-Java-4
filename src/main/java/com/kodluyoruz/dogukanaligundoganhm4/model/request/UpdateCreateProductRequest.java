package com.kodluyoruz.dogukanaligundoganhm4.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCreateProductRequest {
    private String name;
    private String description;
    private String price;
}
