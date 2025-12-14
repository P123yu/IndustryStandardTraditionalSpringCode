package com.basics.ReviseSpringBasics.service;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentDTO createStudent(StudentCO studentCO);

    StudentDTO updateStudent(Long id,StudentCO studentCO);
}
