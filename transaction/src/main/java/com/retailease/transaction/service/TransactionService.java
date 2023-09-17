package com.retailease.transaction.service;

import com.retailease.transaction.payload.request.TransactionReqDto;
import com.retailease.transaction.payload.response.TransactionResDto;

public interface TransactionService {

    TransactionResDto createTransaction(TransactionReqDto transactionReqDto);
}
