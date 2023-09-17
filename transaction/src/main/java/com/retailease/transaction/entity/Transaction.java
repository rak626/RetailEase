package com.retailease.transaction.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;
    @Column(name = "customer_id" )
    private Long customerId;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "total_amount")
    private Long totalAmount;
}
