package com.basics.ReviseSpringBasics.co;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.List;

@Getter
@Setter
public class StudentCO {

    @Schema(example = "1")
    private Long id;

    @NotBlank(message="name can't be blank")
    @Size(max = 20, message = "name length cannot exceed 20 characters")
    @Schema(example = "paul")
    private String name;

    @NotBlank(message="college can't be blank")
    @Schema(example = "mit")
    private String collegeName;

    @NotNull(message = "marks can't be null")
    @Min(value = 0, message = "marks must be 0 or greater")
    @Max(value = 100, message = "marks must be 100 or less")
    @Schema(example = "85.5")
    private Float marks;

    @NotNull(message="rank can't be null")
    @Schema(description = "Student Rank (Must be unique)", example = "5")
    private Long rank;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Schema(type = "string", pattern = "HH:mm:ss", example = "14:30:00")
    private LocalTime fromTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Schema(type = "string", pattern = "dd-MM-yyyy", example = "26-12-2025")
    private LocalDate startingDate;

//    @Schema(type = "string", format = "binary")
//    private MultipartFile imageFile;

    @Schema(type = "string", format = "binary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private MultipartFile imageFile;


    // for sending list of files
    // private List<MultipartFile> imageFiles;

}



//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
//    private LocalTime fromTime;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    private LocalDate startingDate;

//@Schema(
//        description = "Student Rank (Must be unique)", minimum = "1", maximum = "1000", example = "5"
//)


