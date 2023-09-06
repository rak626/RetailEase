package com.retailease.product.services;



import com.retailease.product.entities.Product;
import com.retailease.product.payloads.requests.ProductReqDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductReqDto productReqDto);

    void removeProduct(String barcodeNo, long quantity);

    List<Product> getAllProduct();
}
