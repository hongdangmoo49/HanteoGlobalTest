package com.example.hanteo.board.repository;

import com.example.hanteo.board.entity.Board;
import com.example.hanteo.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByCategory(Category category);
}
