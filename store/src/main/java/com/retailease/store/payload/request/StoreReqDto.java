package com.retailease.store.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreReqDto {
    private String storeName;
    private Long ownerId;
}
