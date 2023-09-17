package com.retailease.transaction.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionReqDto {
    private Long customerId;
    private Long storeId;
    private Long totalAmount;

}
