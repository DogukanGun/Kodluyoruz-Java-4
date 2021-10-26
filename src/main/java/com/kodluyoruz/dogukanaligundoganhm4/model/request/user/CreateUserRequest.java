package com.kodluyoruz.dogukanaligundoganhm4.model.request.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
}
