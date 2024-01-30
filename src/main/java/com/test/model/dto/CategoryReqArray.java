package com.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryReqArray {
    ArrayList<Long> categoryArr;
}
