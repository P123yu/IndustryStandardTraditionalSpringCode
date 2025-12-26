package com.basics.ReviseSpringBasics.service.impl;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.exception.UserNotFoundException;
import com.basics.ReviseSpringBasics.mapper.StudentMapper;
import com.basics.ReviseSpringBasics.repository.StudentRepository;
import com.basics.ReviseSpringBasics.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public StudentDTO createStudent(StudentCO studentCO) {
       return Optional.ofNullable(studentCO)
               .map(studentMapper::coToEntity)
               .map(studentRepository::save)
               .map(studentMapper::entityToDTO)
               .orElseThrow(()->new UserNotFoundException("empty object"));
    }


    @Override
    public StudentDTO updateStudent(Long id, StudentCO studentCO) {
        return Optional.ofNullable(studentCO)
                .filter(co->id != null)
                .filter(co->studentRepository.existsById(id))
                .map(co->{
                    co.setId(id);
                    return studentMapper.coToEntity(co);
                })
                .map(studentRepository::save)
                .map(studentMapper::entityToDTO)
                .orElse(null);
    }


    @Override
    public List<StudentDTO> readAllStudent() {
        return studentRepository.findAll().stream()
                .map(studentMapper::entityToDTO)
                .toList();
    }


    @Override
    public StudentDTO readStudentById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(studentRepository::findById)
                .map(studentMapper::entityToDTO)
                .orElseThrow(() -> new UserNotFoundException("not found"));
    }


    @Override
    public List<StudentDTO> findAllStudentsByCollegeName(String collegeName) {
       return Optional.ofNullable(collegeName)
               .map(studentRepository::findByCollegeName)
               .map(studentMapper::entityListToDTOList)
               .orElseGet(List::of);
    }


    @Override
    public StudentDTO findByRank(Long rank) {
        return Optional.ofNullable(rank)
                .flatMap(studentRepository::findByRank)
                .map(studentMapper::entityToDTO)
                .orElseThrow(() -> new UserNotFoundException("not found"));
    }

    @Override
    public List<StudentDTO> findByMarksBetween(Float marks1, Float marks2) {
        return Optional.ofNullable(marks1)
                .filter(m1 -> marks2 != null)
                .map(m1->studentRepository.findByMarksBetween(m1,marks2))
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> findAllStudentsByRankGreaterThan(Long rank) {
        return Optional.ofNullable(rank)
                .map(studentRepository::findByRankGreaterThan)
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> findAllStudentsByMarksOrCollegeName(Float marks, String collegeName) {
         return Optional.ofNullable(marks)
                 .map(mark->studentRepository.findByMarksOrCollegeName(mark,null))
                 .or(()-> Optional.ofNullable(collegeName)
                         .map(name->studentRepository.findByMarksOrCollegeName(null,name)))
                 .map(studentMapper::entityListToDTOList)
                 .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> findAllStudentsByItsCollegeName(String collegeName) {
        return Optional.ofNullable(collegeName)
                .map(studentRepository::findByCollegeNameContaining)
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);

    }

    @Override
    public List<StudentDTO> findTop3StudentsByName(String name) {
        return Optional.ofNullable(name)
                .map(studentRepository::findTop3ByName)
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> searchStudentByTheirName(String name) {
        return Optional.ofNullable(name)
                .map(studentRepository::findByNameContaining)
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> searchStudentByTheirMarksUsingPagination(
            int pageNo, int pageLength, String sortDir, Float marks
    ) {
        return Optional.ofNullable(marks)
                .map(m -> {
                    Sort sort = sortDir.equalsIgnoreCase("desc")
                            ? Sort.by("marks").descending()
                            : Sort.by("marks").ascending();
                    Pageable pageable = PageRequest.of(pageNo, pageLength, sort);
                    return studentRepository
                                    .findByMarksGreaterThanEqual(m, pageable)
                                    .getContent();
                })
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }

    @Override
    public List<StudentDTO> findByStudentWhoseStartingDateAfter(LocalDate startingDate) {
        return Optional.ofNullable(startingDate)
                .map(studentRepository::findByStartingDateAfter)
                .map(studentMapper::entityListToDTOList)
                .orElseGet(List::of);
    }


//    @Override
//    public List<StudentDTO> findAllStudentsByMarksOrCollegeName(Float marks, String collegeName) {
//        return Stream.of(marks, collegeName)
//                .anyMatch(Objects::nonNull)
//                ? studentMapper.entityListToDTOList(
//                studentRepository.findByMarksOrCollegeName(marks, collegeName))
//                : List.of();
//    }


}

