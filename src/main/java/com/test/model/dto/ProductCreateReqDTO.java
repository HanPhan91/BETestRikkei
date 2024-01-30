package com.test.model.dto;

import com.test.model.Category;
import com.test.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateReqDTO {

    @NotBlank(message = "Vui lòng nhập tiêu đề sản phẩm")
    @Size(min = 5, max = 200, message = "Độ dài tiêu đề sản phẩm từ 5-200 ký tự")
    private String title;

    @NotBlank(message = "Vui lòng nhập giá sản phẩm")
    @Pattern(regexp = "^[0-9]*$", message = "Giá sản phẩm phải là ký tự số")
    private String price;

    private String description;

    @NotBlank(message = "Danh mục sản phẩm không được để trống")
    @Pattern(regexp = "^[0-9]*$", message = "Danh mục sản phẩm không hợp lệ")
    private String categoryId;

    public Product toProduct(Category category) {
        return new Product()
                .setTitle(title)
                .setPrice(BigDecimal.valueOf(Long.parseLong(price)))
                .setDescription(description)
                .setCategory(category)
                ;

    }
}
