package com.retailease.transactionItem.controller;

import com.retailease.transactionItem.payload.request.TransactionItemReqDto;
import com.retailease.transactionItem.payload.response.TransactionItemResDto;
import com.retailease.transactionItem.service.TransactionItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactionItems")
public class TransactionItemController {

    private final TransactionItemService transactionItemService;

    public TransactionItemController(TransactionItemService transactionItemService) {
        this.transactionItemService = transactionItemService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addTransactionItem(@RequestBody TransactionItemReqDto transactionItemReqDto){
        TransactionItemResDto transactionItemResDto = transactionItemService.createTransactionItem(transactionItemReqDto);
        return new ResponseEntity<>(transactionItemResDto, HttpStatus.CREATED);
    }
}
