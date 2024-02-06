package com.sesac.sesacspring.service;

import com.sesac.sesacspring.domain.Board;
import com.sesac.sesacspring.dto.BoardDTO;
import com.sesac.sesacspring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;
    public List<BoardDTO> selectAll() {
        List<Board> boards = boardMapper.selectAll();
        List<BoardDTO> result = new ArrayList<>();

        for(Board board : boards){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setNo(board.getNo() + 100);
            boardDTO.setId(board.getId());
            boardDTO.setWriter(board.getWriter());
            boardDTO.setTitle(board.getTitle());
            boardDTO.setDate(board.getDate());

            result.add(boardDTO);
        }
        return result;
    }


}
