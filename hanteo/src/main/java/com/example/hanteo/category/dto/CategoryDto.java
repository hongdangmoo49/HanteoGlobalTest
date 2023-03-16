package com.example.hanteo.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryDto> children;
}
