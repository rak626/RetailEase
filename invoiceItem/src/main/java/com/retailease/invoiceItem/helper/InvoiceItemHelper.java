package com.retailease.invoiceItem.helper;


import com.retailease.invoiceItem.entity.InvoiceItem;
import com.retailease.invoiceItem.payload.response.InvoiceItemResDto;

public class InvoiceItemHelper {
    public static InvoiceItemResDto invoiceResDtoMapper(InvoiceItem invoiceItem){
        return InvoiceItemResDto.builder()
                .invoiceItemId(invoiceItem.getInvoiceItemId())
                .invoiceId(invoiceItem.getInvoiceId())
                .productId(invoiceItem.getProductId())
                .quantity(invoiceItem.getQuantity())
                .subtotal(invoiceItem.getSubtotal())
                .build();
    }
}
