package com.retailease.transactionItem.payload.response;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItemResDto {
    private Long transactionItemId;
    private Long productId;
    private Long quantity;
    private Long subtotal;
}
