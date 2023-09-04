package com.rakesh.RetailEase.controllers;

import com.rakesh.RetailEase.payloads.requests.ProductReqDto;
import com.rakesh.RetailEase.payloads.response.ApiResponse;
import com.rakesh.RetailEase.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/add")
    public ApiResponse addProduct(@RequestBody ProductReqDto productReqDto){
        return productService.addProduct(productReqDto);
    }

    @PostMapping("/remove")
    public ApiResponse removeProduct(@RequestParam long quantity){
        return productService.removeProduct(quantity);
    }
}
