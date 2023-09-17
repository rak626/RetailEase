package com.retailease.transaction.payload.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResDto {
    private Long transactionId;
    private Long customerId;
    private Long storeId;
    private Date transactionDate;
    private Long totalAmount;
}
