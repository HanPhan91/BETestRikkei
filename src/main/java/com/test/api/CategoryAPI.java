package com.test.api;

import com.test.model.Category;
import com.test.model.dto.CategoryCreateReqDTO;
import com.test.model.dto.CategoryResDTO;
import com.test.service.category.ICategoryService;
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
@RequestMapping("/api/categories")
public class CategoryAPI {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Category> categoryList = categoryService.getAllByDeletedIsFalse();

        List<CategoryResDTO> categoryResDTOList = new ArrayList<>();

        for (Category category : categoryList) {
            categoryResDTOList.add(category.toCategoryResDTO());
        }

        return new ResponseEntity<>(categoryResDTOList, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryCreateReqDTO categoryCreateReqDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Category category = categoryService.create(categoryCreateReqDTO);

        return new ResponseEntity<>(category.toCategoryCreateResDTO(), HttpStatus.CREATED);
    }
}
