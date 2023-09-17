package com.retailease.invoice.service.impl;

import com.retailease.invoice.entity.Invoice;
import com.retailease.invoice.helper.InvoiceHelper;
import com.retailease.invoice.payload.request.InvoiceReqDto;
import com.retailease.invoice.payload.response.InvoiceResDto;
import com.retailease.invoice.repository.InvoiceRepo;
import com.retailease.invoice.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepo invoiceRepo;

    public InvoiceServiceImpl(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    @Override
    public InvoiceResDto createInvoice(InvoiceReqDto invoiceReqDto) {
        Invoice invoice = Invoice.builder()
                .invoiceDate(new Date())
                .dueDate(invoiceReqDto.getDueDate())
                .storeId(invoiceReqDto.getStoreId())
                .totalAmount(invoiceReqDto.getTotalAmount())
                .build();
        Invoice savedInvoice = invoiceRepo.save(invoice);

        return InvoiceHelper.invoiceResDtoMapper(savedInvoice);
    }
}
