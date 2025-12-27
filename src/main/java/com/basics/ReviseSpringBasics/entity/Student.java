package com.basics.ReviseSpringBasics.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="student")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",length=20)
    private String name;

    @Column(name="college_name")
    private String collegeName;

    @Column(name="marks")
    private Float marks;

    @Column(name="student_rank",unique = true, nullable = false)
    private Long rank;

    @Column(name="starting_date")
    private LocalDate startingDate;

    @Column(name="fromTime")
    private LocalTime fromTime;

    @Column(name="ending_date")
    private LocalDate endingDate;

    @Column(name="image_name",length=500)
    private String imageName;

    @Column(name="image_data",columnDefinition = "BYTEA")
    private byte[] imageData;

    @Column(name="image_type")
    private String imageType;
}
