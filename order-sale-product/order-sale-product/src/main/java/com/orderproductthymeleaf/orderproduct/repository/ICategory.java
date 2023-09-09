package com.orderproductthymeleaf.orderproduct.repository;

import com.orderproductthymeleaf.orderproduct.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategory extends JpaRepository<Category,Integer> {

}
