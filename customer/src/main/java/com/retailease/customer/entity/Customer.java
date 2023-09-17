package com.retailease.customer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    Long customerId;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "email")
    String email;
    @Column(name = "phone")
    String phone;
    /*@Column(name = "address")
    String address;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;*/
    @Column(name = "registration_date")
    Date registrationDate;
}
