package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.domain.Board;
import com.sesac.sesacspring.dto.BoardDTO;
import com.sesac.sesacspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board/mybatis")
public class BoardController {
    // 5개의 메소드
    // 1. 전체 조회 => board.html 렌더링
    // 2. 작성(create): axios (동적폼전송, post) = @RequestBody
    // 3. 수정(update): axios (동적폼전송, patch)
    // 4. 삭제(delete): axios (동적폼전송, delete)
    // 5. 검색(조회): axios (동적폼전송, get)

    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String getMain(Model model) {
        List<BoardDTO> result = boardService.selectAll();
        model.addAttribute("board", result);
        return "board";
    }

}
