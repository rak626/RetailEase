package com.retailease.invoiceItem.payload.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItemResDto {
    private Long invoiceItemId;
    private Long invoiceId;
    private Long productId;
    private Long quantity;
    private Long subtotal;
}
