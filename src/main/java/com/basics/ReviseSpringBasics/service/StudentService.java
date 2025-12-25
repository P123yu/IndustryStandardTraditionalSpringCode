package com.basics.ReviseSpringBasics.service;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDTO createStudent(StudentCO studentCO);

    StudentDTO updateStudent(Long id,StudentCO studentCO);

    List<StudentDTO> readAllStudent();

    StudentDTO readStudentById(Long id);

    List<StudentDTO> findAllStudentsByCollegeName(String collegeName);

    StudentDTO findByRank(Long rank);

    List<StudentDTO> findByMarksBetween(Float marks1,Float marks2);

    List<StudentDTO> findAllStudentsByRankGreaterThan(Long rank);

    List<StudentDTO> findAllStudentsByMarksOrCollegeName(Float marks,String collegeName);

    List<StudentDTO> findAllStudentsByItsCollegeName(String collegeName);

    List<StudentDTO> findTop3StudentsByName(String name);

    List<StudentDTO> searchStudentByTheirName(String name);

    List<StudentDTO> searchStudentByTheirMarksUsingPagination(int pageNo,int pageLength,String sortDir,Float marks);




}
