package com.basics.ReviseSpringBasics.mapper;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student coToEntity(StudentCO studentCO);
    StudentDTO entityToDTO(Student student);
}
