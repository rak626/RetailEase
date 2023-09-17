package com.retailease.customer.payload.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReqDto {

    String firstName;
    String lastName;
    String email;
    String phone;
}
