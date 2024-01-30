package com.test.model.dto;

import com.test.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryCreateReqDTO {

    @NotBlank(message = "Vui lòng nhập tiêu đề danh mục")
    private String title;

    public Category toCategory() {
        return new Category()
                .setTitle(title)
                ;
    }
}
