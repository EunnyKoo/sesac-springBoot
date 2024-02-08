package com.sesac.sesacspring.service;

import com.sesac.sesacspring.dto.StudentDTO;
import com.sesac.sesacspring.entity.Student;
import com.sesac.sesacspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> getStudentAll() {
        List<Student> result = studentRepository.findAll();
        List<StudentDTO> students = new ArrayList<>();

        for (Student student : result) {
            // Builder: 객체를 만들 때 순서에 의해 생기는 문제, 명시적이지 못한 문제를 해결하기 위해 나온 방법
            // 생성자 주입: 여러개의 필드가 있을 때 순서를 지켜줘야 한다.
            // setter: 필드 개수만큼 매번 메소드를 만들어줘야 한다.
            StudentDTO studentDTO = StudentDTO.builder() // new Builder
                    .name(student.getName())
                    .nickname(student.getNickname())
                    .build();
            students.add(studentDTO);
        }
        return students;
    }

    public String insertStudent(String name, String nickname, Student.LoginType type) {
        // 받아온 데이터로 repository의 save 메소드 호출
        Student student = Student.builder().name(name).nickname(nickname).loginType(type).build();
        Student newStudent = studentRepository.save(student);
        //newStudent: save를 한 후 반환되는 Entity 객체
        return newStudent.getId() + newStudent.getName();
    }

    public String searchStudentByName(String name) {
        List<Student> student = studentRepository.findByName(name);
        return student.size() + "명이 검색되었습니다.";
    }

    public String searchStudentById(int id) {
        Optional<Student> student = studentRepository
                .findById(id);
//있으면 반환하고 없으면 error 처리  .orElseThrow(()->new RuntimeException("사용자가 없다!"));
        // Optional<T> : java 8부터 등장
        // null일 수도 있는 객체를 감싸는 wrapper 클래스
        if (student.isPresent()) {
            // isPresent: 객체의 여부를 boolean으로 반환
            return student.get().getName();
            // get: Optional에 담긴 객체를 반환
        }
        return null;
    }

    public String countStudent(String nickname) {
        int student = studentRepository.countByNickname(nickname);
        return "해당 닉네임 수: " + student;
    }

    public String updateStudent(int id, String name) {
        // save(T) : 새로운 entity를 삽입 or 기존 entity update
        // T의 기본값(pk)의 상태에 따라 다르게 동작
        // - pk값이 존재하는 경우: pk와 연결된 entity를 update
        // - pk값이 없는 경우: 새로운 entity를 insert
        Student student = studentRepository.findById(id).orElseThrow(()->new NoSuchElementException("없는 id입니다."));
        Student modifiedStudent = Student.builder().id(id).name(name).nickname(student.getNickname()).loginType(student.getLoginType()).build();
        Student newStudent = studentRepository.save(modifiedStudent);
        return "Update Success";
//        if(studentRepository.findById(id).isEmpty()){
//            return "입력한 " + id + ": 존재하지 않음";
//        }else{
//            studentRepository.save(Student.builder().id(id).name(name).build());
//            return id + "의 이름을 " + name + "으로 변경하였습니다.";
//        }
//    }
    }
}
