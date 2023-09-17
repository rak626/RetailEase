package com.retailease.storeOwner.payload.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreOwnerReqDto {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
}
