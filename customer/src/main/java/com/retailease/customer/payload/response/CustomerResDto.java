package com.retailease.customer.payload.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date registrationDate;
}
