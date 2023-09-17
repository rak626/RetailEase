package com.retailease.customer.controller;

import com.retailease.customer.payload.request.CustomerReqDto;
import com.retailease.customer.payload.response.CustomerResDto;
import com.retailease.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createNewCustomer(@RequestBody CustomerReqDto customerReqDto) {
        CustomerResDto customerResDto = customerService.addNewCustomer(customerReqDto);
        return new ResponseEntity<>(customerResDto, HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
        String msg = "Deleted Successfully";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerReqDto customerReqDto) {
        CustomerResDto customerResDto = customerService.updateCustomer(customerId, customerReqDto);
        return new ResponseEntity<>(customerResDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> findAllCustomers() {
        List<CustomerResDto> allCustomers = customerService.findAllCustomer();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long customerId){
        CustomerResDto customerResDto = customerService.findCustomerById(customerId);
        return ResponseEntity.ok(customerResDto);

    }

    @GetMapping("/search")
    public ResponseEntity<?> findCustomerByType(@RequestParam String type, @RequestParam String value) {

        List<CustomerResDto> customerByType = customerService.findCustomerByType(type, value);
        return new ResponseEntity<>(customerByType, HttpStatus.OK);
    }

}
