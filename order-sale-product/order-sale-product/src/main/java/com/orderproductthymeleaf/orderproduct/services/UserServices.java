package com.orderproductthymeleaf.orderproduct.services;

import com.orderproductthymeleaf.orderproduct.models.Userss;
import com.orderproductthymeleaf.orderproduct.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private IUser iUser;

    public List<Userss> findAllUser() {
        return iUser.findAll();
    }

    public void saveUser(Userss theUser) {
        iUser.save(theUser);
    }
}
