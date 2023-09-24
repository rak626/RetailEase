package com.retailease.product.services;



import com.retailease.product.entities.Product;
import com.retailease.product.payloads.request.ProductReqDto;
import com.retailease.product.payloads.response.ProductResDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductReqDto productReqDto);

    void removeProduct(String barcodeNo, long quantity);

    List<Product> getAllProduct();

    ProductResDto addNewProduct(ProductReqDto productReqDto);

    void removeProduct(Long productId);

    ProductResDto updateProduct(Long productId, ProductReqDto productReqDto);

    ProductResDto findProductById(Long productId);
}
