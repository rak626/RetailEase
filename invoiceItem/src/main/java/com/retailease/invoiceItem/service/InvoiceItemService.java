package com.retailease.invoiceItem.service;


import com.retailease.invoiceItem.payload.request.InvoiceItemReqDto;
import com.retailease.invoiceItem.payload.response.InvoiceItemResDto;

public interface InvoiceItemService {

    InvoiceItemResDto createInvoiceItem(InvoiceItemReqDto invoiceItemReqDto);
}
