package com.example.springregister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springregister.Seller;

public interface SellerRepository extends JpaRepository <Seller, String> {

}
