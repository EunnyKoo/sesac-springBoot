package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.dto.StudentDTO;
import com.sesac.sesacspring.entity.Student;
import com.sesac.sesacspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    //1. 전체 검색 (select * from student)
    @GetMapping("/all")
    public List<StudentDTO> getAll(){
        // student의 목록을 전부 가져와서 보여주는 api
        List<StudentDTO> result = studentService.getStudentAll();
        return result;
    }
    //2. 삽입 ( insert into ~~ )
    @GetMapping("/insert") // /student/insert?name=이름
    public String insertStudent(@RequestParam String name, @RequestParam String nickname, @RequestParam Student.LoginType type){
        // 이름, 닉네임, login_type
        studentService.insertStudent(name, nickname, type);
        return name + type;
    }

    //3. 조건에 따른 검색(select * from student name='')
    //4. 조건에 따른 검색(2) (select * from student where id=)

//    @GetMapping("/search")
//    public ? getSearch(@RequestBody int id){
//
//    }

    //    @GetMapping("/count")
//    public int getCountAll(){
//
//    }
}
