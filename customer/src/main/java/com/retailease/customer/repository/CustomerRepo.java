package com.retailease.customer.repository;

import com.retailease.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Optional<Customer>> findAllByFirstName(String firstName);
    List<Optional<Customer>> findAllByLastName(String firstName);
    List<Optional<Customer>> findAllByEmail(String firstName);
    List<Optional<Customer>> findAllByPhone(String firstName);


}
