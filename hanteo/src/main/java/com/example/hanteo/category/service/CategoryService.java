package com.example.hanteo.category.service;

import com.example.hanteo.category.dto.CategoryDto;
import com.example.hanteo.category.entity.Category;
import com.example.hanteo.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto findByIdAndName(Long id, String name) {
        Category category = categoryRepository.findByIdAndName(id, name);
        List<CategoryDto> childrenDtos = new ArrayList<>();
        for (Category child : category.getChildren()) {
            List<CategoryDto> grandChildrenDtos = new ArrayList<>();
            for (Category grandChild : child.getChildren()) {
                CategoryDto grandChildDto = new CategoryDto(grandChild.getId(), grandChild.getName(),
                        (grandChild.getParent() != null) ? grandChild.getParent().getId() : null,
                        Collections.emptyList());
                grandChildrenDtos.add(grandChildDto);
            }
            CategoryDto childDto = new CategoryDto(child.getId(), child.getName(),
                    (child.getParent() != null) ? child.getParent().getId() : null,
                    grandChildrenDtos);
            childrenDtos.add(childDto);
        }
        CategoryDto categoryDto = new CategoryDto(category.getId(), category.getName(),
                (category.getParent() != null) ? category.getParent().getId() : null,
                childrenDtos);
        return categoryDto;
    }
}
