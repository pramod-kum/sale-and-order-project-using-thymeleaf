package com.orderproductthymeleaf.orderproduct.repository;

import com.orderproductthymeleaf.orderproduct.models.Orderss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrder extends JpaRepository<Orderss,Integer> {

}
