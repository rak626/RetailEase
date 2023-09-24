package com.retailease.product.controllers;


import com.retailease.product.entities.Product;
import com.retailease.product.payloads.request.ProductReqDto;
import com.retailease.product.payloads.response.ApiResponse;
import com.retailease.product.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/add")
    public ApiResponse addProduct(@RequestBody ProductReqDto productReqDto) {
        logger.info("Add Product service call initiated");
        productService.addProduct(productReqDto);
        logger.info("Add product service call completed");
        return new ApiResponse("Product Added", HttpStatus.ACCEPTED);
    }

    @PostMapping("/remove")
    public ApiResponse removeProduct(@RequestParam String barcodeNo, @RequestParam long quantity) {
        logger.info("Remove Product service call initiated");
        productService.removeProduct(barcodeNo, quantity);
        logger.info("Remove product service call completed");
        return new ApiResponse(String.format("%s Product Removed", quantity), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<Product> displayAllProducts() {
        return productService.getAllProduct();
    }
}
