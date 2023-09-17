package com.retailease.customer.helper;

import com.retailease.customer.entity.Customer;
import com.retailease.customer.payload.response.CustomerResDto;

public class CustomerHelper {

    public static CustomerResDto customerResDtoMapper(Customer customer) {
        return CustomerResDto.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .registrationDate(customer.getRegistrationDate())
                .build();
    }
}
