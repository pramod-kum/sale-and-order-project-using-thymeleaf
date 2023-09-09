package com.orderproductthymeleaf.orderproduct.repository;

import com.orderproductthymeleaf.orderproduct.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISubCategory extends JpaRepository<SubCategory,Integer> {
    @Modifying
    @Query(value = "select * from sub_category where category_category_id =:tempCategoryId",nativeQuery = true)
    List<SubCategory> findBySubCategoryByCategoryId(Integer tempCategoryId);
}
