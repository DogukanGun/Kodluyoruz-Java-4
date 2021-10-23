package com.kodluyoruz.dogukanaligundoganhm4.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreateUserRequest {
    private String id;
    private String oldPassword;
    private String newPassword;
    private String email;
}
