package com.basics.ReviseSpringBasics.controller;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.service.StudentService;
import com.basics.ReviseSpringBasics.util.Constant;
import com.basics.ReviseSpringBasics.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @PostMapping(Constant.CREATE_URL)
    public ResponseEntity<ResponseUtil>createStudent(@RequestBody @Valid StudentCO studentCO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseUtil.builder().status(HttpStatus.CREATED.value())
                        .success(true).message(Constant.CREATE)
                        .data(studentService.createStudent(studentCO)).build()
        );
    }


    @PutMapping(Constant.UPDATE_URL+"/{id}")
    public ResponseEntity<ResponseUtil>updateStudent(@PathVariable Long id, @RequestBody StudentCO studentCO){
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder().status(HttpStatus.OK.value())
                .success(true).message(Constant.UPDATE)
                        .data(studentService.updateStudent(id,studentCO)).build()
        );
    }


    @GetMapping(Constant.READ_URL)
    public ResponseEntity<ResponseUtil> readAllStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.readAllStudent()).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/id/{id}")
    public ResponseEntity<ResponseUtil> readStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.readStudentById(id)).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/collegeName/{collegeName}")
    public ResponseEntity<ResponseUtil> findAllStudentsByCollegeName(@PathVariable String collegeName) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.findAllStudentsByCollegeName(collegeName)).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/rank/{rank}")
    public ResponseEntity<ResponseUtil> findByRank(@PathVariable Long rank) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.findByRank(rank)).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/{marks1}/{marks2}")
    public ResponseEntity<ResponseUtil> findByMarksBetween(@PathVariable Float marks1,
                                                           @PathVariable Float marks2) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.findByMarksBetween(marks1,marks2)).build()
        );
    }


    @GetMapping(Constant.READ_URL + "/marksOrCollegeName")
    public ResponseEntity<ResponseUtil> findAllStudentsByMarksOrCollegeName(
            @RequestParam(required = false) Float marks,
            @RequestParam(required = false) String collegeName) {

        if (marks == null && collegeName == null) {
            return ResponseEntity.badRequest().body(
                    ResponseUtil.builder().status(HttpStatus.NOT_FOUND.value())
                            .message("Either marks or collegeName must be provided")
                            .success(false).data(null).build()
            );
        }


        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService
                                .findAllStudentsByMarksOrCollegeName(marks,collegeName)).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/top3Name/{name}")
    public ResponseEntity<ResponseUtil> findByMarksBetween(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.findTop3StudentsByName(name)).build()
        );
    }



    @GetMapping(Constant.READ_URL+"/searchName/{name}")
    public ResponseEntity<ResponseUtil> searchStudentByTheirName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.searchStudentByTheirName(name)).build()
        );
    }



    @GetMapping(Constant.READ_URL+"/searchNameUsingPagination")
    public ResponseEntity<ResponseUtil> searchStudentByTheirMarksUsingPagination(
            @RequestParam(required = false , defaultValue = "0") int pageNo,
            @RequestParam(required = false, defaultValue = "10") int pageLength,
            @RequestParam(required = false, defaultValue = "desc") String sortDir,
            @RequestParam Float marks) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.searchStudentByTheirMarksUsingPagination(pageNo,
                                pageLength,sortDir,marks)).build()
        );
    }


    @GetMapping(Constant.READ_URL+"/afterStartingDate")
    public ResponseEntity<ResponseUtil> findByStudentWhoseStartingDateAfter(
            @RequestParam LocalDate startingDate){
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseUtil.builder()
                        .status(HttpStatus.OK.value()).message(Constant.READ)
                        .success(true).data(studentService.findByStudentWhoseStartingDateAfter(startingDate)).build()
        );
    }

}

