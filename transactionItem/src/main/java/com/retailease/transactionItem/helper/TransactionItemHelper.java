package com.retailease.transactionItem.helper;

import com.retailease.transactionItem.entity.TransactionItem;
import com.retailease.transactionItem.payload.response.TransactionItemResDto;

public class TransactionItemHelper {
    public static TransactionItemResDto invoiceResDtoMapper(TransactionItem transactionItem){
        return TransactionItemResDto.builder()
                .transactionItemId(transactionItem.getTransactionItemId())
                .productId(transactionItem.getProductId())
                .quantity(transactionItem.getQuantity())
                .subtotal(transactionItem.getSubtotal())
                .build();
    }
}
