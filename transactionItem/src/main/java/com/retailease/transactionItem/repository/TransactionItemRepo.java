package com.retailease.transactionItem.repository;



import com.retailease.transactionItem.entity.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionItemRepo extends JpaRepository<TransactionItem, Long> {
}
