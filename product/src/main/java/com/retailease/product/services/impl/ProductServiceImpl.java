package com.retailease.product.services.impl;


import com.retailease.product.entities.Product;
import com.retailease.product.exceptions.InvalidQuantityException;
import com.retailease.product.exceptions.ResourceNotFoundException;
import com.retailease.product.payloads.requests.ProductReqDto;
import com.retailease.product.repositories.ProductRepo;
import com.retailease.product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addProduct(ProductReqDto productReqDto) {
        Optional<Product> retrieveProduct = productRepo.findByBarcodeNo(productReqDto.getBarcodeNo());
        if (retrieveProduct.isEmpty()) {
            logger.info("Product not found , Trying to create new Product");
            Product newProduct = Product.builder()
                    .barcodeNo(productReqDto.getBarcodeNo())
                    .quantity(productReqDto.getQuantity())
                    .build();
            productRepo.save(newProduct);
        } else {
            Product product = retrieveProduct.get();
            product.setQuantity(product.getQuantity() + productReqDto.getQuantity());
            productRepo.save(product);
            logger.info("Product found, and updated successfully");
        }
    }

    @Override
    public void removeProduct(String barcodeNo, long quantity) {
        Product product = productRepo.findByBarcodeNo(barcodeNo).orElseThrow(() -> new ResourceNotFoundException("Product", barcodeNo));

        if (quantity > product.getQuantity()) {
            logger.warn("Invalid quantity");
            throw new InvalidQuantityException(product.getId(), barcodeNo, quantity, product.getQuantity());
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            productRepo.save(product);
            logger.info("Product is removed");
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}
