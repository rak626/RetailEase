package com.retailease.storeOwner.repository;

import com.retailease.storeOwner.entity.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreOwnerRepo extends JpaRepository<StoreOwner, Long> {
}
