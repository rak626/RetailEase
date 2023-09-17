package com.retailease.storeOwner.service.impl;

import com.retailease.storeOwner.entity.StoreOwner;
import com.retailease.storeOwner.helper.StoreOwnerHelper;
import com.retailease.storeOwner.payload.request.StoreOwnerReqDto;
import com.retailease.storeOwner.payload.response.StoreOwnerResDto;
import com.retailease.storeOwner.repository.StoreOwnerRepo;
import com.retailease.storeOwner.service.StoreOwnerService;
import org.springframework.stereotype.Service;

@Service
public class StoreOwnerServiceImpl implements StoreOwnerService {

    private final StoreOwnerRepo storeOwnerRepo;

    public StoreOwnerServiceImpl(StoreOwnerRepo storeOwnerRepo) {
        this.storeOwnerRepo = storeOwnerRepo;
    }

    @Override
    public StoreOwnerResDto addStore(StoreOwnerReqDto storeOwnerReqDto) {
        StoreOwner storeOwner = StoreOwner.builder()
                .email(storeOwnerReqDto.getEmail())
                .phone(storeOwnerReqDto.getPhone())
                .address(storeOwnerReqDto.getAddress())
                .firstname(storeOwnerReqDto.getFirstname())
                .lastname(storeOwnerReqDto.getLastname())
                .build();
        StoreOwner savedStoreOwner = storeOwnerRepo.save(storeOwner);
        return StoreOwnerHelper.storeOwnerResDtoMapper(savedStoreOwner);
    }
}
