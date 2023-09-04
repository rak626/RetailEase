package com.rakesh.RetailEase.repositories;

import com.rakesh.RetailEase.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
