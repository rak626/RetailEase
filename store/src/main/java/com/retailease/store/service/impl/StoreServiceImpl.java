package com.retailease.store.service.impl;

import com.retailease.store.entity.Store;
import com.retailease.store.helper.StoreHelper;
import com.retailease.store.payload.request.StoreReqDto;
import com.retailease.store.payload.response.StoreResDto;
import com.retailease.store.repository.StoreRepo;
import com.retailease.store.service.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;

    public StoreServiceImpl(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    @Override
    public StoreResDto addStore(StoreReqDto storeReqDto) {
        Store store = Store.builder()
                .storeName(storeReqDto.getStoreName())
                .ownerId(storeReqDto.getOwnerId())
                .build();
        Store savedStore = storeRepo.save(store);
        return StoreHelper.storeResDtoMapper(savedStore);
    }
}
