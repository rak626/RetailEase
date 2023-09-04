package com.rakesh.RetailEase.payloads.requests;

import lombok.Getter;

@Getter
public class ProductReqDto {
    private String barcodeNo;
    private Long quantity;
}
