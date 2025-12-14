package com.basics.ReviseSpringBasics.controller;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.service.StudentService;
import com.basics.ReviseSpringBasics.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?>createStudent(@RequestBody StudentCO studentCO){
        StudentDTO studentDTO=studentService.createStudent(studentCO);
        ResponseUtil responseUtil=ResponseUtil.builder()
                .status(HttpStatus.CREATED.value())
                .success(true).message("student created")
                .data(studentDTO).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUtil);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?>createStudent(@PathVariable Long id, @RequestBody StudentCO studentCO){
        StudentDTO studentDTO=studentService.updateStudent(id,studentCO);
        ResponseUtil responseUtil=ResponseUtil.builder()
                .status(HttpStatus.OK.value())
                .success(true).message("student updated")
                .data(studentDTO).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseUtil);
    }
}
