package com.basics.ReviseSpringBasics.service.impl;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.entity.Student;
import com.basics.ReviseSpringBasics.mapper.StudentMapper;
import com.basics.ReviseSpringBasics.repository.StudentRepository;
import com.basics.ReviseSpringBasics.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO createStudent(StudentCO studentCO) {
        Student student=studentMapper.coToEntity(studentCO);
        student=studentRepository.save(student);
        return studentMapper.entityToDTO(student);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentCO studentCO) {
        boolean isStudentExists=studentRepository.existsById(id);
        if(!isStudentExists){
            return null;
        }
        studentCO.setId(id);
        Student student=studentMapper.coToEntity(studentCO);
        student=studentRepository.save(student);
        return studentMapper.entityToDTO(student);
    }
}
