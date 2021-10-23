package com.kodluyoruz.dogukanaligundoganhm4.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "baskets")
@NoArgsConstructor
@AllArgsConstructor
public class Basket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private User user;



    //burada product - basket iliskisinde her productda basket listesi mi olmali



}
