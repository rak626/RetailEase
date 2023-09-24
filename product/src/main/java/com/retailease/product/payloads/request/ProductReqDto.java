package com.retailease.product.payloads.request;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReqDto {
    private String barcodeNo;
    private Long quantity;
    private Double price;
    private String category;
    private Long storeId;
    private String name;
}
