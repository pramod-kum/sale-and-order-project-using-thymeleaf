package com.orderproductthymeleaf.orderproduct.controller;

import com.orderproductthymeleaf.orderproduct.models.Category;
import com.orderproductthymeleaf.orderproduct.models.Orderss;
import com.orderproductthymeleaf.orderproduct.models.SubCategory;
import com.orderproductthymeleaf.orderproduct.models.Userss;
import com.orderproductthymeleaf.orderproduct.services.OrderService;
import com.orderproductthymeleaf.orderproduct.services.ProductServices;
import com.orderproductthymeleaf.orderproduct.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private ProductServices productServicesObj;
    @Autowired
    private OrderService orderService;

//    private Integer tempUserId;
//    private Integer tempCategoryId;

@GetMapping("/userInterface")
public String userInterface(Model model) {

    List<Userss> userlist=userServices.findAllUser();
    model.addAttribute("user123",userlist);
    List<Category> categoryList=productServicesObj.findAllCategory();
    model.addAttribute("categories", categoryList);
    return "user-interface"; // Return the name of your Thymeleaf template
}

    @GetMapping("/addUser")
    public String addUser(Model theModel){
        Userss useObj=new Userss();
        theModel.addAttribute("user111",useObj);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user111") Userss theUser){
        userServices.saveUser(theUser);
      return "redirect:/userInterface";
    }


    @GetMapping("/subcategories")
    @ResponseBody
    public List<SubCategory> getSubcategories(@RequestParam Integer categoryId) {
      return productServicesObj.findAllSubCategoryByCategoryId(categoryId);

    }

    @GetMapping("/success")
    public String showSuccessPage() {

        return "success"; // Replace "success" with the actual template name

    }

@PostMapping("/submit")
public String handleSubmitForm(@RequestParam("selectedSubcategoryId") Integer selectedSubcategoryId , @RequestParam("intCategorIdValue") int theUserId) {
    // Handle the selected subcategory ID here, e.g., save it to a database or perform other actions.
    System.out.println("Selected Subcategory ID: " + selectedSubcategoryId);
    orderService.saveOrder(theUserId,selectedSubcategoryId);
    // You can redirect to a success page or return a response as needed.
     return "success"; // Redirect to a success page
}

    @GetMapping("/orderInterface")
    public String orderInterface(Model theModel){
        List<Orderss> orderssList=orderService.findAllOrder();
        theModel.addAttribute("order12",orderssList);

        return "order-interface";
    }
}
