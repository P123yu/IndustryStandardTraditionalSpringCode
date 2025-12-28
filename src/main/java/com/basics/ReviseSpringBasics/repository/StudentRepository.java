package com.basics.ReviseSpringBasics.repository;

import com.basics.ReviseSpringBasics.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    List<Student>findByCollegeName(String collegeName);

    Optional<Student>findByRank(Long rank);

    List<Student>findByMarksBetween(Float marks1,Float marks2);

    List<Student>findByRankGreaterThan(Long rank);

    List<Student>findByMarksOrCollegeName(Float marks,String collegeName);

    List<Student> findByCollegeNameContaining(String collegeName);

    List<Student> findTop3ByName(String name);

    List<Student> findByNameContaining(String name);

    Page<Student> findByMarksGreaterThanEqual(Float marks, Pageable pageable);

    List<Student> findByStartingDateAfter(LocalDate startingDate);


//    // starting_date <= fromDate AND ending_date >= toDate
//    List<Student> findByStartingDateLessThanEqualAndEndingDateGreaterThanEqual(
//            LocalDate startingDate,
//            LocalDate endingDate
//    );


//    SELECT *
//    FROM student
//    WHERE starting_date < :fromDate
//    AND ending_date > :toDate;

    List<Student> findByStartingDateBeforeAndEndingDateAfter(
            LocalDate fromDate,
            LocalDate toDate
    );



}
