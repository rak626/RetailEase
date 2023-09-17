package com.retailease.customer.service.impl;

import com.retailease.customer.entity.Customer;
import com.retailease.customer.exceptions.ResourceNotFoundException;
import com.retailease.customer.helper.CustomerHelper;
import com.retailease.customer.payload.request.CustomerReqDto;
import com.retailease.customer.payload.response.CustomerResDto;
import com.retailease.customer.repository.CustomerRepo;
import com.retailease.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerResDto addNewCustomer(CustomerReqDto customerReqDto) {
        Customer customer = Customer.builder()
                .firstName(customerReqDto.getFirstName())
                .lastName(customerReqDto.getLastName())
                .email(customerReqDto.getEmail())
                .phone(customerReqDto.getPhone())
                .registrationDate(new Date())
                .build();

        Customer savedCustomer = customerRepo.save(customer);

        return CustomerHelper.customerResDtoMapper(savedCustomer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
        customerRepo.delete(customer);
    }

    @Override
    public CustomerResDto updateCustomer(Long customerId, CustomerReqDto customerReqDto) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));

        if (customerReqDto.getFirstName() != null) customer.setFirstName(customerReqDto.getFirstName());
        if (customerReqDto.getLastName() != null) customer.setLastName(customerReqDto.getLastName());
        if (customerReqDto.getEmail() != null) customer.setEmail(customerReqDto.getEmail());
        if (customerReqDto.getPhone() != null) customer.setPhone(customerReqDto.getPhone());
        Customer savedCustomer = customerRepo.save(customer);

        return CustomerHelper.customerResDtoMapper(savedCustomer);
    }

    @Override
    public List<CustomerResDto> findCustomerByType(String type, String value) {
        List<Customer> customerList = new ArrayList<>();
        if (type.equalsIgnoreCase("firstname")) {
            List<Optional<Customer>> foundCustomerList = customerRepo.findAllByFirstName(value);
            customerList = foundCustomerList.stream().map(customer -> customer.orElse(null)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("lastname")) {
            List<Optional<Customer>> foundCustomerList = customerRepo.findAllByLastName(value);
            customerList = foundCustomerList.stream().map(customer -> customer.orElse(null)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("email")) {
            List<Optional<Customer>> foundCustomerList = customerRepo.findAllByEmail(value);
            customerList = foundCustomerList.stream().map(customer -> customer.orElse(null)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("phone")) {
            List<Optional<Customer>> foundCustomerList = customerRepo.findAllByPhone(value);
            customerList = foundCustomerList.stream().map(customer -> customer.orElse(null)).collect(Collectors.toList());
        }
        return customerList.stream().map(CustomerHelper::customerResDtoMapper).collect(Collectors.toList());
    }

    @Override
    public CustomerResDto findCustomerById(Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        return CustomerHelper.customerResDtoMapper(customer);
    }

    @Override
    public List<CustomerResDto> findAllCustomer() {
        List<Customer> allCustomers = customerRepo.findAll();

        return allCustomers.stream().map(CustomerHelper::customerResDtoMapper)
                .collect(Collectors.toList());
    }
}
