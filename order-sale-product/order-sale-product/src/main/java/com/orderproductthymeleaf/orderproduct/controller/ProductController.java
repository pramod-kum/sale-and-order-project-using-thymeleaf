package com.orderproductthymeleaf.orderproduct.controller;

import com.orderproductthymeleaf.orderproduct.models.Category;
import com.orderproductthymeleaf.orderproduct.models.SubCategory;
import com.orderproductthymeleaf.orderproduct.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

   private Integer storeId;

    @Autowired
    private ProductServices productServices;

    @GetMapping("/productInterface")
    public String productInterface(Model theModel){
        List<Category> listCategory= productServices.findAllCategory();

        theModel.addAttribute("category123",listCategory);

        return "category-interface";

    }
    @GetMapping("/showCategoryForm")
    public String showCategoryForm(Model theModel){

        Category categoryobj=new Category();

        theModel.addAttribute("categorys",categoryobj);

        return "category-form";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("categorys") Category category){

        productServices.saveCategory(category);

        return "redirect:/productInterface";
    }

    @GetMapping("/showSubCategoryForm")
    public String showSubCategoryForm(@RequestParam("categoryId") Integer id , Model theModel){
        storeId=id;
        SubCategory subCategoryObj=new SubCategory();
        theModel.addAttribute("subcategory",subCategoryObj);
        return "sub-category-form";
    }

    @PostMapping("/addSubCategory")
    public String addSubCategory(@ModelAttribute("subcategory") SubCategory theSubCategory){
        if(storeId==null){
            System.out.println("storId is Null...");
        }
       Category categoryObject = productServices.findCategoryObjById(storeId);
        productServices.saveSubCategory(categoryObject,theSubCategory);

        return "redirect:/productInterface";
    }

    @GetMapping("/showSubCategory")
    public String showSubCategory(Model theModel){
        List<SubCategory> subCategorlist = productServices.findAllSubCategory();
        theModel.addAttribute("category1",subCategorlist);
        return "showsubcategory-interface";
    }
}
