package com.retailease.product.services.impl;


import com.retailease.product.entities.Product;
import com.retailease.product.exceptions.InvalidQuantityException;
import com.retailease.product.exceptions.ResourceNotFoundException;
import com.retailease.product.helper.ProductHelper;
import com.retailease.product.payloads.request.ProductReqDto;
import com.retailease.product.payloads.response.ProductResDto;
import com.retailease.product.repositories.ProductRepo;
import com.retailease.product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
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
            Product newProduct = Product.builder().barcodeNo(productReqDto.getBarcodeNo()).quantity(productReqDto.getQuantity()).name(productReqDto.getName()).category(productReqDto.getCategory()).price(productReqDto.getPrice()).storeId(productReqDto.getStoreId()).build();
            productRepo.save(newProduct);
        } else {
            Product product = retrieveProduct.get();
            product.setQuantity(product.getQuantity() + productReqDto.getQuantity());
            product.setPrice(productReqDto.getPrice());
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

    @Override
    public ProductResDto addNewProduct(ProductReqDto productReqDto) {
        Product product = Product.builder().barcodeNo(productReqDto.getBarcodeNo()).name(productReqDto.getName()).quantity(productReqDto.getQuantity()).category(productReqDto.getCategory()).price(productReqDto.getPrice()).storeId(productReqDto.getStoreId()).build();
        Product savedProduct = productRepo.save(product);


        return ProductHelper.productResDtoMapper(savedProduct);
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", productId));
        productRepo.delete(product);
    }

    @Override
    public ProductResDto updateProduct(Long productId, ProductReqDto productReqDto) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", productId));

        if (productReqDto.getBarcodeNo() != null) product.setBarcodeNo(productReqDto.getBarcodeNo());
        if (productReqDto.getQuantity() != null) product.setQuantity(productReqDto.getQuantity());
        if (productReqDto.getCategory() != null) product.setCategory(productReqDto.getCategory());
        if (productReqDto.getPrice() != null) product.setPrice(productReqDto.getPrice());
        if (productReqDto.getName() != null) product.setName(productReqDto.getName());
        if (productReqDto.getStoreId() != null) product.setStoreId(productReqDto.getStoreId());

        Product savedProduct = productRepo.save(product);
        return ProductHelper.productResDtoMapper(savedProduct);
    }

    @Override
    public ProductResDto findProductById(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", productId));
        return ProductHelper.productResDtoMapper(product);
    }
}
