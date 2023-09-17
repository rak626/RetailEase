package com.retailease.transaction.helper;

import com.retailease.transaction.entity.Transaction;
import com.retailease.transaction.payload.response.TransactionResDto;

public class TransactionHelper {
    public static TransactionResDto invoiceResDtoMapper(Transaction transaction){
        return TransactionResDto.builder()
                .transactionId(transaction.getTransactionId())
                .customerId(transaction.getCustomerId())
                .transactionDate(transaction.getTransactionDate())
                .totalAmount(transaction.getTotalAmount())
                .storeId(transaction.getStoreId())
                .build();
    }
}
