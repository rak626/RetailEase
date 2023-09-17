package com.retailease.invoice.service;

import com.retailease.invoice.entity.Invoice;
import com.retailease.invoice.payload.request.InvoiceReqDto;
import com.retailease.invoice.payload.response.InvoiceResDto;

public interface InvoiceService {

    InvoiceResDto createInvoice(InvoiceReqDto invoiceReqDto);
}
