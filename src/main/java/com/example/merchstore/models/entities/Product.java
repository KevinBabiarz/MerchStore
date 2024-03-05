package com.example.merchstore.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String name;

    @Column(name = "product_quantity", nullable = false)
    private Long quantity;

    @Column(name = "product_img", nullable = false)
    private String img;

    @Column(name = "product_price", nullable = false)
    private Long price;

    public Product(String name, Long quantity, String img, Long price) {
    }

    public Product() {

    }

}

