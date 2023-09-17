package com.retailease.invoice.payload.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceReqDto {
    private Long storeId;
    private Date dueDate;
    private Long totalAmount;

}
