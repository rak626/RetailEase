package com.retailease.invoice.controller;

import com.retailease.invoice.payload.request.InvoiceReqDto;
import com.retailease.invoice.payload.response.InvoiceResDto;
import com.retailease.invoice.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInvoice(@RequestBody InvoiceReqDto invoiceReqDto){
        InvoiceResDto invoice = invoiceService.createInvoice(invoiceReqDto);
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }
}
