package com.sesac.sesacspring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    // 값을 전달하기 위함
    private int no;
    private int id;
    private String writer;
    private String title;
    private Date date;
}
