package com.retailease.product.payloads.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDto {
    private Long id;
    private Long quantity;
    private String barcodeNo;
    private Double price;
    private String category;
    private Long storeId;
    private String name;
}
