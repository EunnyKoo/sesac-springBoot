package com.sesac.sesacspring.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentDTO {
    private String name;
    private String nickname;
}
