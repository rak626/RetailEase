package com.retailease.transactionItem.service;

import com.retailease.transactionItem.payload.request.TransactionItemReqDto;
import com.retailease.transactionItem.payload.response.TransactionItemResDto;

public interface TransactionItemService {

    TransactionItemResDto createTransactionItem(TransactionItemReqDto transactionItemReqDto);
}
