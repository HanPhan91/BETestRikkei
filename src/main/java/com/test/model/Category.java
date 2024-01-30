package com.test.model;

import com.test.model.dto.CategoryCreateResDTO;
import com.test.model.dto.CategoryResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
@Accessors(chain = true)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public CategoryCreateResDTO toCategoryCreateResDTO() {
        return new CategoryCreateResDTO()
                .setId(id)
                .setTitle(title)
                ;
    }

    public CategoryResDTO toCategoryResDTO() {
        return new CategoryResDTO()
                .setId(id)
                .setTitle(title)
                ;
    }

}
