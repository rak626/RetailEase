package com.rakesh.RetailEase.services.impl;

import com.rakesh.RetailEase.payloads.requests.ProductReqDto;
import com.rakesh.RetailEase.payloads.response.ApiResponse;
import com.rakesh.RetailEase.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ApiResponse addProduct(ProductReqDto productReqDto) {
        return ApiResponse.builder().message("product added").httpStatus(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ApiResponse removeProduct(long quantity) {
        System.out.println("product delete");
        return ApiResponse.builder().message("product delete").httpStatus(HttpStatus.ACCEPTED).build();
    }
}
