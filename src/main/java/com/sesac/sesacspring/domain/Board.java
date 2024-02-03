package com.sesac.sesacspring.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Board {
    private int no;
    private int id;
    private String writer;
    private String title;
    private Date date;
}
