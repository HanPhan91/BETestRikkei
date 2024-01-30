package com.test.repository;

import com.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.test.model.Product (" +
                "prd.id, " +
                "prd.title, " +
                "prd.price, " +
                "prd.description, " +
                "prd.category" +
            ") " +
            "FROM Product AS prd " +
            "WHERE prd.category.id IN :categoryArr " +
            "AND prd.deleted = false " +
            "AND prd.category.deleted = false"
    )
    List<Product> filterProductByCategoryId(ArrayList<Long> categoryArr);

    @Query("SELECT NEW com.test.model.Product (" +
                "prd.id, " +
                "prd.title, " +
                "prd.price, " +
                "prd.description, " +
                "prd.category" +
            ") " +
            "FROM Product AS prd " +
            "WHERE prd.deleted = false " +
            "AND prd.category.deleted = false"
    )
    List<Product> getAllByDeletedIsFalseAndCategoryDeletedIsFalse();

    Boolean existsByTitleAndCategoryId(String title, long categoryId);
}
