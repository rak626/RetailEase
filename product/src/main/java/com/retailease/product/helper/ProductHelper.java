package com.retailease.product.helper;

import com.retailease.product.entities.Product;
import com.retailease.product.payloads.response.ProductResDto;

public class ProductHelper {
    public static ProductResDto productResDtoMapper(Product product) {
        return ProductResDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .barcodeNo(product.getBarcodeNo())
                .storeId(product.getStoreId())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }
}
