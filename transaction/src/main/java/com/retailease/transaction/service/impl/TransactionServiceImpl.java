package com.retailease.transaction.service.impl;

import com.retailease.transaction.entity.Transaction;
import com.retailease.transaction.helper.TransactionHelper;
import com.retailease.transaction.payload.request.TransactionReqDto;
import com.retailease.transaction.payload.response.TransactionResDto;
import com.retailease.transaction.repository.TransactionRepo;
import com.retailease.transaction.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public TransactionResDto createTransaction(TransactionReqDto transactionReqDto) {
        Transaction transaction = Transaction.builder()
                .transactionDate(new Date())
                .customerId(transactionReqDto.getCustomerId())
                .totalAmount(transactionReqDto.getTotalAmount())
                .storeId(transactionReqDto.getStoreId())
                .build();
        Transaction savedTransaction = transactionRepo.save(transaction);
        return TransactionHelper.invoiceResDtoMapper(savedTransaction);
    }
}
