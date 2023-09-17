package com.retailease.transactionItem.payload.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItemReqDto {
    private Long productId;
    private Long quantity;
    private Long subtotal;

}
