package com.orderproductthymeleaf.orderproduct.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orderss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    //@JoinColumn(name = "user_user_id")
    Userss userss;
    @ManyToOne
    //@JoinColumn(name = "subcategory_product_id")
     SubCategory subCategory;

}
