package com.example.hanteo.category.repository;

import com.example.hanteo.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByIdAndName(Long id, String name);
}
