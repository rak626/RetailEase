package com.rakesh.RetailEase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "barcode_no")
    private String barcodeNo;

}
