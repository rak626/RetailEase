package com.retailease.storeOwner.helper;

import com.retailease.storeOwner.entity.StoreOwner;
import com.retailease.storeOwner.payload.response.StoreOwnerResDto;

public class StoreOwnerHelper {
    public static StoreOwnerResDto storeOwnerResDtoMapper(StoreOwner storeOwner){
        return StoreOwnerResDto.builder()
                .ownerId(storeOwner.getOwnerId())
                .address(storeOwner.getAddress())
                .phone(storeOwner.getPhone())
                .email(storeOwner.getEmail())
                .lastname(storeOwner.getLastname())
                .firstname(storeOwner.getFirstname())
                .address(storeOwner.getAddress())
                .build();
    }
}
