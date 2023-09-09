package com.orderproductthymeleaf.orderproduct.services;

import com.orderproductthymeleaf.orderproduct.models.Category;
import com.orderproductthymeleaf.orderproduct.models.SubCategory;
import com.orderproductthymeleaf.orderproduct.repository.ICategory;
import com.orderproductthymeleaf.orderproduct.repository.ISubCategory;
import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ICategory iCategory;
    @Autowired
    private ISubCategory iSubCategory;

    public List<Category> findAllCategory() {
        return iCategory.findAll();
    }

    public void saveCategory(Category category) {
        iCategory.save(category);
    }

    public Category findCategoryObjById(Integer storeId) {
        return iCategory.findById(storeId).get();
    }

    public void saveSubCategory(Category categoryObject, SubCategory theSubCategory) {
        theSubCategory.setCategory(categoryObject);
        iSubCategory.save(theSubCategory);
    }

    public List<SubCategory> findAllSubCategory() {
        return iSubCategory.findAll();
    }

    public List<Category> findAll() {
        return iCategory.findAll();
    }
@Transactional
    public List<SubCategory> findAllSubCategoryByCategoryId(Integer tempCategoryId) {
        return iSubCategory.findBySubCategoryByCategoryId(tempCategoryId);
    }
}
