package com.retailease.product.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "barcode_no")
    private String barcodeNo;
    @Column(name = "price")
    private Double price;
    @Column(name = "category")
    private String category;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "product_name")
    private String name;
}
