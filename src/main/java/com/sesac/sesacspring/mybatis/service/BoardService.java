package com.sesac.sesacspring.mybatis.service;

import com.sesac.sesacspring.mybatis.domain.Board;
import com.sesac.sesacspring.mybatis.dto.BoardDTO;
import com.sesac.sesacspring.mybatis.mapper.BoardMapper;
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
            boardDTO.setId(board.getId());
            boardDTO.setWriter(board.getWriter());
            boardDTO.setTitle(board.getTitle());

            result.add(boardDTO);
        }
        return result;
    }

    public boolean insertBoard(BoardDTO boardDTO) {
        Board board;
        board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setWriter(boardDTO.getWriter());
        boardMapper.insertBoard(board);
        return true;
    }

    public void patchBoard(BoardDTO boardDTO) {
        // board.getBoardID // title, content, writer
        Board board;
        board = new Board();
        board.setId(boardDTO.getId());
        board.setTitle(boardDTO.getTitle());
        board.setWriter(boardDTO.getWriter());
        boardMapper.patchBoard(board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

    public int searchBoard(String word) {
        List<Board> result = boardMapper.searchBoard(word);
        return result.size();
    }
}
