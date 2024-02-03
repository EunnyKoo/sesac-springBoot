package com.sesac.sesacspring.mapper;

import com.sesac.sesacspring.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectAll();

    @Insert("insert into board(id, title, writer, date) values(#{id}, #{title}, #{writer}, sysdate)")
    void createBoard(int no, int id, String title, String writer, String date);

    @Update("update board set ")
    void updateBoard(Board board);

}
