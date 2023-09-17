package com.retailease.transaction.controller;

import com.retailease.transaction.payload.request.TransactionReqDto;
import com.retailease.transaction.payload.response.TransactionResDto;
import com.retailease.transaction.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@RequestBody TransactionReqDto transactionReqDto){
        TransactionResDto transactionResDto = transactionService.createTransaction(transactionReqDto);
        return new ResponseEntity<>(transactionResDto, HttpStatus.CREATED);
    }
}
