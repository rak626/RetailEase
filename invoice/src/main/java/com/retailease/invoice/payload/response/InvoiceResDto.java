package com.retailease.invoice.payload.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceResDto {

    private Long invoiceId;
    private Long storeId;
    private Date invoiceDate;
    private Date dueDate;
    private Long totalAmount;
}
