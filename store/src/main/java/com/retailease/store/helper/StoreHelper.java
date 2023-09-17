package com.retailease.store.helper;

import com.retailease.store.entity.Store;
import com.retailease.store.payload.response.StoreResDto;

public class StoreHelper {
    public static StoreResDto storeResDtoMapper(Store store){
        return StoreResDto.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .ownerId(store.getOwnerId())
                .build();
    }
}
