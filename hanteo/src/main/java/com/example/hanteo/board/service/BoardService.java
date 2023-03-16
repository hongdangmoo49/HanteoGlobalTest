package com.example.hanteo.board.service;

import com.example.hanteo.board.dto.BoardDto;
import com.example.hanteo.board.entity.Board;
import com.example.hanteo.board.repository.BoardRepository;
import com.example.hanteo.category.entity.Category;
import com.example.hanteo.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    public List<BoardDto> findByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        List<Board> boardList = boardRepository.findByCategory(category);
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boardList) {
            BoardDto boardDto = new BoardDto(board.getId(), board.getName(), categoryId);
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
}
