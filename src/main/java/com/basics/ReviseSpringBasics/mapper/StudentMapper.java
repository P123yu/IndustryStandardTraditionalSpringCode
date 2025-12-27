//package com.basics.ReviseSpringBasics.mapper;
//
//import com.basics.ReviseSpringBasics.co.StudentCO;
//import com.basics.ReviseSpringBasics.dto.StudentDTO;
//import com.basics.ReviseSpringBasics.entity.Student;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface StudentMapper {
//
//    @Mapping(target = "imageName", ignore = true)
//    @Mapping(target = "imageData", ignore = true)
//    @Mapping(target = "imageType", ignore = true)
//    Student coToEntity(StudentCO studentCO);
//
//    @Mapping(target = "imageData",
//            expression = "java(com.basics.ReviseSpringBasics.util.ByteToBase64Util." +
//                    "byteArrayToBase64(student.getImageData()))")
//    StudentDTO entityToDTO(Student student);
//
//    List<StudentDTO> entityListToDTOList(List<Student> students);
//}



package com.basics.ReviseSpringBasics.mapper;

import com.basics.ReviseSpringBasics.co.StudentCO;
import com.basics.ReviseSpringBasics.dto.StudentDTO;
import com.basics.ReviseSpringBasics.entity.Student;
import com.basics.ReviseSpringBasics.util.ByteToBase64Util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ByteToBase64Util.class)
public interface StudentMapper {

    @Mapping(target = "imageData", ignore = true)
    Student coToEntity(StudentCO studentCO);

    @Mapping(target = "imageDataBase64", source = "imageData")
    StudentDTO entityToDTO(Student student);

    List<StudentDTO> entityListToDTOList(List<Student> students);
}
