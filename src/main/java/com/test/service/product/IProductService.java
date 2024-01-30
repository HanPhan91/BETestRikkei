package com.test.service.product;

import com.test.model.Product;
import com.test.model.dto.ProductCreateReqDTO;
import com.test.service.IGeneralService;

import java.util.ArrayList;
import java.util.List;

public interface IProductService extends IGeneralService<Product, Long> {

    List<Product> getAllByDeletedIsFalseAndCategoryDeletedIsFalse();

    List<Product> filterProductByCategoryId(ArrayList<Long> categoryArr);

    Product create(ProductCreateReqDTO productCreateReqDTO);
}
