package com.retailease.product.payloads.requests;

import lombok.Getter;


@Getter
public class ProductReqDto {
    private String barcodeNo;
    private Long quantity;
    private String price;
    private String category;
    private Long storeId;
    private String name;
}
