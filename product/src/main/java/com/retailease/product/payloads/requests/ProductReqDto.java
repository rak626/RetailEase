package com.retailease.product.payloads.requests;

import lombok.Getter;

@Getter
public class ProductReqDto {
    private String barcodeNo;
    private Long quantity;
}
