package com.kodluyoruz.dogukanaligundoganhm4.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCreateCategoryRequest {
    private String name;
    private Integer parentId;
}
