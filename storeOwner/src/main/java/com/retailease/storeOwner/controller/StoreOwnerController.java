package com.retailease.storeOwner.controller;

import com.retailease.storeOwner.payload.request.StoreOwnerReqDto;
import com.retailease.storeOwner.payload.response.StoreOwnerResDto;
import com.retailease.storeOwner.service.StoreOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/owners")
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;

    public StoreOwnerController(StoreOwnerService storeOwnerService) {
        this.storeOwnerService = storeOwnerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStoreOwner(@RequestBody StoreOwnerReqDto storeOwnerReqDto) {
        StoreOwnerResDto storeOwnerResDto = storeOwnerService.addStore(storeOwnerReqDto);
        return new ResponseEntity<>(storeOwnerResDto, HttpStatus.CREATED);
    }
}
