package com.rakesh.RetailEase.services;

import com.rakesh.RetailEase.payloads.requests.ProductReqDto;
import com.rakesh.RetailEase.payloads.response.ApiResponse;

public interface ProductService {

    ApiResponse addProduct(ProductReqDto productReqDto);
    ApiResponse removeProduct(long quantity);
}
