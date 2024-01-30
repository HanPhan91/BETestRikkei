package com.test.service.category;

import com.test.model.Category;
import com.test.model.dto.CategoryCreateReqDTO;
import com.test.service.IGeneralService;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category, Long> {

    List<Category> getAllByDeletedIsFalse();

    Category create(CategoryCreateReqDTO categoryCreateReqDTO);
}
