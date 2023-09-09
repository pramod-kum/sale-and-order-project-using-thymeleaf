package com.orderproductthymeleaf.orderproduct.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subCategoryId;
    private String subCategoryName;
    private String price;

    @ManyToOne
    //@JoinColumn(name = "category_category_id")
    private Category category;
}
