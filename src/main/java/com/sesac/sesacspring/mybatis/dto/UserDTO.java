package com.sesac.sesacspring.mybatis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private int id;
    private String writer;
    private String title;
    private Date date;

    public void setNickname(String nickname) {
    }

    public void setName(String name) {
    }
}
