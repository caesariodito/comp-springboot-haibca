package com.example.springboothai2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String product_name;

    private Integer product_number;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer stock;

}
