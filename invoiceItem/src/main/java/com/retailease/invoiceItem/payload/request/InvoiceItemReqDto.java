package com.retailease.invoiceItem.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItemReqDto {
    private Long invoiceId;
    private Long productId;
    private Long quantity;
    private Long subtotal;

}
