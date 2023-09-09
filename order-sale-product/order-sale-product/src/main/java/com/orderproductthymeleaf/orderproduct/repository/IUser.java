package com.orderproductthymeleaf.orderproduct.repository;

import com.orderproductthymeleaf.orderproduct.models.Userss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<Userss,Integer> {
}
