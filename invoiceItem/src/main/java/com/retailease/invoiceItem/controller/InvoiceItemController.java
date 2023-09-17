package com.retailease.invoiceItem.controller;

import com.retailease.invoiceItem.payload.request.InvoiceItemReqDto;
import com.retailease.invoiceItem.payload.response.InvoiceItemResDto;
import com.retailease.invoiceItem.service.InvoiceItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoiceItems")
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInvoiceItem(@RequestBody InvoiceItemReqDto invoiceItemReqDto){
        InvoiceItemResDto invoiceItem = invoiceItemService.createInvoiceItem(invoiceItemReqDto);
        return new ResponseEntity<>(invoiceItem, HttpStatus.CREATED);
    }
}
