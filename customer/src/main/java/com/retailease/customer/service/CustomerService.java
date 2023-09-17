package com.retailease.customer.service;

import com.retailease.customer.payload.request.CustomerReqDto;
import com.retailease.customer.payload.response.CustomerResDto;

import java.util.List;

public interface CustomerService {

    CustomerResDto addNewCustomer(CustomerReqDto customerReqDto);

    void deleteCustomerById(Long customerId);

    CustomerResDto updateCustomer(Long customerId, CustomerReqDto customerReqDto);

    List<CustomerResDto> findCustomerByType(String type, String value);

    CustomerResDto findCustomerById(Long customerId);

    List<CustomerResDto> findAllCustomer();


}
