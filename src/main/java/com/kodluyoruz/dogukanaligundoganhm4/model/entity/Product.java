package com.kodluyoruz.dogukanaligundoganhm4.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@SQLDelete(sql = "UPDATE products SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 300)
    private String description;

    @Column(nullable = false,length = 50)
    private String price;

    @Column(name = "category_id")
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private Category category;
}
