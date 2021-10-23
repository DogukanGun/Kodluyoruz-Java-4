package com.kodluyoruz.dogukanaligundoganhm4.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@SuperBuilder
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column()
    private String username;

    private String name;

    private String email;

    private String surname;

    private String password;
}
