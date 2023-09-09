package com.orderproductthymeleaf.orderproduct.services;

import com.orderproductthymeleaf.orderproduct.models.Orderss;
import com.orderproductthymeleaf.orderproduct.models.SubCategory;
import com.orderproductthymeleaf.orderproduct.models.Userss;
import com.orderproductthymeleaf.orderproduct.repository.IOrder;
import com.orderproductthymeleaf.orderproduct.repository.ISubCategory;
import com.orderproductthymeleaf.orderproduct.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrder iOrder;
    @Autowired
    private IUser iUserObj;
    @Autowired
    private ISubCategory iSubCategoryobj;

public void saveOrder(Integer tempUserId, Integer selectedSubcategoryId) {
    Userss userssObject = iUserObj.findById(tempUserId).get();
    SubCategory subCategoryObject = iSubCategoryobj.findById(selectedSubcategoryId).get();
    Orderss orderss =new Orderss();
    orderss.setUserss(userssObject);
    orderss.setSubCategory(subCategoryObject);
    iOrder.save(orderss);
}
    public List<Orderss> findAllOrder() {
        return iOrder.findAll();
    }
}
