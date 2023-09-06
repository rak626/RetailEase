package com.retailease.product.repositories;


import com.retailease.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByBarcodeNo(String barcodeNo);

}
