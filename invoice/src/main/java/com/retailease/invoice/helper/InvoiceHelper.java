package com.retailease.invoice.helper;

import com.retailease.invoice.entity.Invoice;
import com.retailease.invoice.payload.response.InvoiceResDto;

public class InvoiceHelper {
    public static InvoiceResDto invoiceResDtoMapper(Invoice invoice){
        return InvoiceResDto.builder()
                .invoiceId(invoice.getInvoiceId())
                .dueDate(invoice.getDueDate())
                .storeId(invoice.getStoreId())
                .invoiceDate(invoice.getInvoiceDate())
                .totalAmount(invoice.getTotalAmount())
                .build();
    }
}
