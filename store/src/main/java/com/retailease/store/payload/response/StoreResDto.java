package com.retailease.store.payload.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreResDto {
    private Long storeId;
    private String storeName;
    private Long ownerId;
}
