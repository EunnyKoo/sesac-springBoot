package com.sesac.sesacspring.mybatis.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class Board {
    public int id;
    public String writer;
    public String title;
}
