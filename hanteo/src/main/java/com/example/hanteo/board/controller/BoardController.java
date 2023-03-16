package com.example.hanteo.board.controller;

import com.example.hanteo.board.dto.BoardDto;
import com.example.hanteo.board.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/{categoryId}")
    public List<BoardDto> findByCategoryId(@PathVariable Long categoryId) {
        return boardService.findByCategoryId(categoryId);
    }
}
