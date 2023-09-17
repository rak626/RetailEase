package com.retailease.store.controller;

import com.retailease.store.payload.request.StoreReqDto;
import com.retailease.store.payload.response.StoreResDto;
import com.retailease.store.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStore(@RequestBody StoreReqDto storeReqDto) {
        StoreResDto storeResDto = storeService.addStore(storeReqDto);
        return new ResponseEntity<>(storeResDto, HttpStatus.CREATED);
    }
}
