package com.retailease.invoiceItem.repository;

import com.retailease.invoiceItem.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepo extends JpaRepository<InvoiceItem, Long> {
}
