package com.retailease.transactionItem.service.impl;


import com.retailease.transactionItem.entity.TransactionItem;
import com.retailease.transactionItem.helper.TransactionItemHelper;
import com.retailease.transactionItem.payload.request.TransactionItemReqDto;
import com.retailease.transactionItem.payload.response.TransactionItemResDto;
import com.retailease.transactionItem.repository.TransactionItemRepo;
import com.retailease.transactionItem.service.TransactionItemService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionItemServiceImpl implements TransactionItemService {

    private final TransactionItemRepo transactionItemRepo;

    public TransactionItemServiceImpl(TransactionItemRepo transactionItemRepo) {
        this.transactionItemRepo = transactionItemRepo;
    }

    @Override
    public TransactionItemResDto createTransactionItem(TransactionItemReqDto transactionItemReqDto) {
        TransactionItem transactionItem = TransactionItem.builder()
                .productId(transactionItemReqDto.getProductId())
                .quantity(transactionItemReqDto.getQuantity())
                .subtotal(transactionItemReqDto.getSubtotal())
                .build();
        TransactionItem savedTransactionItem = transactionItemRepo.save(transactionItem);
        return TransactionItemHelper.invoiceResDtoMapper(savedTransactionItem);
    }
}
