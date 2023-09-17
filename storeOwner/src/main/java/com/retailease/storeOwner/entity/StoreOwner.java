package com.retailease.storeOwner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "store_owners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
}
