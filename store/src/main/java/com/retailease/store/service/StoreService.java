package com.retailease.store.service;

import com.retailease.store.payload.request.StoreReqDto;
import com.retailease.store.payload.response.StoreResDto;

public interface StoreService {

    StoreResDto addStore(StoreReqDto storeReqDto);
}
