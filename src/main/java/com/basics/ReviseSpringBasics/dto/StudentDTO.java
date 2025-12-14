package com.basics.ReviseSpringBasics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends BaseDTO{
    private Long id;
    private String name;
    private String collegeName;
    private Float marks;
}
