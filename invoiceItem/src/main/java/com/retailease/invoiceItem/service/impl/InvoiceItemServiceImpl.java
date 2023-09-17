package com.retailease.invoiceItem.service.impl;

import com.retailease.invoiceItem.entity.InvoiceItem;
import com.retailease.invoiceItem.helper.InvoiceItemHelper;
import com.retailease.invoiceItem.payload.request.InvoiceItemReqDto;
import com.retailease.invoiceItem.payload.response.InvoiceItemResDto;
import com.retailease.invoiceItem.repository.InvoiceItemRepo;
import com.retailease.invoiceItem.service.InvoiceItemService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepo invoiceItemRepo;

    public InvoiceItemServiceImpl(InvoiceItemRepo invoiceItemRepo) {
        this.invoiceItemRepo = invoiceItemRepo;
    }

    @Override
    public InvoiceItemResDto createInvoiceItem(InvoiceItemReqDto invoiceItemReqDto) {
        InvoiceItem invoiceItem = InvoiceItem.builder()
                .invoiceId(invoiceItemReqDto.getInvoiceId())
                .productId(invoiceItemReqDto.getProductId())
                .quantity(invoiceItemReqDto.getQuantity())
                .subtotal(invoiceItemReqDto.getSubtotal())
                .build();
        InvoiceItem savedInvoiceItem = invoiceItemRepo.save(invoiceItem);

        return InvoiceItemHelper.invoiceResDtoMapper(savedInvoiceItem);
    }
}
