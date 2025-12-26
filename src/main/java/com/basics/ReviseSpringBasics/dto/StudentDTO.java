package com.basics.ReviseSpringBasics.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class StudentDTO extends BaseDTO{
    private Long id;
    private String name;
    private String collegeName;
    private Float marks;
    private Long rank;
    private LocalTime fromTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startingDate;
}
