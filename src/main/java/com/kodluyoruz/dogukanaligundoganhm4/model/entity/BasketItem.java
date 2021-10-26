package com.kodluyoruz.dogukanaligundoganhm4.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Data
@Entity
 @SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket_items")
public class BasketItem extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(nullable = false)
    private int quantity;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",nullable = false,insertable = false,updatable = false)
    private Product product;

    @Column(name = "basket_id")
    private Integer basketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id",insertable = false,updatable = false)
    private Basket basket;

}
