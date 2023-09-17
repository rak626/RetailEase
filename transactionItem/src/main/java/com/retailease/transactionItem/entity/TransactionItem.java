package com.retailease.transactionItem.entity;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_item_id")
    private Long transactionItemId;
    @Column(name = "product_id" )
    private Long productId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "subtotal")
    private Long subtotal;
}
