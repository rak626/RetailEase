package com.retailease.storeOwner.payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreOwnerResDto {
    private Long ownerId;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
}
