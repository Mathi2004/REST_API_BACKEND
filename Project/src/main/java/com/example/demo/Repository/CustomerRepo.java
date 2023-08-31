package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.CustomerModel;

public interface CustomerRepo extends JpaRepository<CustomerModel, Integer>{

}