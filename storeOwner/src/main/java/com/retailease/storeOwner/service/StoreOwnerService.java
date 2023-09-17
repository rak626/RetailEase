package com.retailease.storeOwner.service;

import com.retailease.storeOwner.payload.request.StoreOwnerReqDto;
import com.retailease.storeOwner.payload.response.StoreOwnerResDto;

public interface StoreOwnerService {

    StoreOwnerResDto addStore(StoreOwnerReqDto storeOwnerReqDto);
}
