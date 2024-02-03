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
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String getMain(Model model) {
        List<BoardDTO> result = boardService.selectAll();
        model.addAttribute("board", result);
        return "board";
    }

    @PostMapping("")
    public String getBoardInsert(
            @RequestParam int no,
            @RequestParam int id,
            @RequestParam String title,
            @RequestParam String writer,
            @RequestParam String date
    ){
        boardService.createBoard(no, id, title, writer, date);
        return "board";
    }

    @PostMapping("/update")
    public String getBoardUpdate(Board board){
        boardService.updateBoard(board);
       return "board";
    }
}
