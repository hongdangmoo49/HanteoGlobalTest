package com.example.hanteo.category.controller;

import com.example.hanteo.category.dto.CategoryDto;
import com.example.hanteo.category.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}/{name}")
    public CategoryDto findByIdAndName(@PathVariable Long id, @PathVariable String name) {
        return categoryService.findByIdAndName(id, name);
    }
}
