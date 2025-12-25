package com.basics.ReviseSpringBasics.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="college_name")
    private String collegeName;

    @Column(name="marks")
    private Float marks;

    @Column(name="student_rank")
    private Long rank;
}
