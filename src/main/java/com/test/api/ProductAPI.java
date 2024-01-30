package com.test.api;

import com.test.model.Category;
import com.test.model.Product;
import com.test.model.dto.CategoryReqArray;
import com.test.model.dto.ProductCreateReqDTO;
import com.test.model.dto.ProductResDTO;
import com.test.service.product.IProductService;
import com.test.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IProductService productService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Product> productList = productService.getAllByDeletedIsFalseAndCategoryDeletedIsFalse();

        List<ProductResDTO> productResDTOList = new ArrayList<>();

        for (Product product : productList) {
            Category category = product.getCategory();
            ProductResDTO productResDTO = product.toProductResDTO(category);
            productResDTOList.add(productResDTO);
        }

        return new ResponseEntity<>(productResDTOList, HttpStatus.OK);
    }

    @PostMapping("/filter-by-category-id")
    public ResponseEntity<?> filterProductByCategoryId(@RequestBody CategoryReqArray categoryReqArray) {
        List<Product> productList = productService.filterProductByCategoryId(categoryReqArray.getCategoryArr());

        List<ProductResDTO> productResDTOList = new ArrayList<>();

        for (Product product : productList) {
            Category category = product.getCategory();
            ProductResDTO productResDTO = product.toProductResDTO(category);
            productResDTOList.add(productResDTO);
        }

        return new ResponseEntity<>(productResDTOList, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody ProductCreateReqDTO productCreateReqDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Product product = productService.create(productCreateReqDTO);

        return new ResponseEntity<>(product.toProductCreateResDTO(), HttpStatus.CREATED);
    }
}
