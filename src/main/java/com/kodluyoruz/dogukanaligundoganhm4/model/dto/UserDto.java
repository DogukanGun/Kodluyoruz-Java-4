package com.kodluyoruz.dogukanaligundoganhm4.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;

    private String name;

    private String surname;

    private String email;

}
