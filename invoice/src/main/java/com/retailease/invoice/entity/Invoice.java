package com.retailease.invoice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;
    @Column(name = "store_id" )
    private Long storeId;
    @Column(name = "invoice_data")
    private Date invoiceDate;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "total_amount")
    private Long totalAmount;
}
