package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.dto.StudentDTO;
import com.sesac.sesacspring.entity.Student;
import com.sesac.sesacspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return studentService.insertStudent(name, nickname, type);
    }

    //3. 조건에 따른 검색(select * from student name='')
    //4. 조건에 따른 검색(2) (select * from student where id=)

    @GetMapping("/search/name")  // student/search/name?name=이름
    public String getSearch(@RequestParam String name){
        return studentService.searchStudentByName(name);
    }

    @GetMapping("/search/id")
    public String searchStudentById(@RequestParam int id){
        return studentService.searchStudentById(id);
    }

    @GetMapping("/count/nickname") // /student/count/nickname?nickname=값
    public String countStudent(@RequestParam String nickname){
        return studentService.countStudent(nickname);
    }

    @GetMapping("/update/id")
    public String updateStudent(@RequestParam int id, @RequestParam String name){
        return studentService.updateStudent(id, name);
    }
}
