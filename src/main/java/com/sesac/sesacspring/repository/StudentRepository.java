package com.sesac.sesacspring.repository;

import com.sesac.sesacspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//JPARepository<대상으로 지정할 엔티티, 해당 엔티티의 pk 타입>
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 1. jpa의 기본 규칙을 따르는 방법
    // findBy컬럼명
    // select * from student where name=#{name}
    List<Student> findByName(String name); // primary key, unique key
//    List<Student> findByNameAndNickname(String name, String nickname); // 이름과 닉네임이 모두 일치하는 경우
//    List<Student> fingByNameOrNickname(String name, String nickname); //이름이 일치하거나 닉네임이 일치하는 경우
    // findByAgeGreaterThanEqual(int age) //age가 값보다 크거나 같은 경우

    // 2. 직접 쿼리를 작성해서 연결
    //@Query("select s from Student s where s.name= :name")
//    @Query(nativeQuery = true, value = "select * from student where name= :name")
//    List<Student> findTest(String name);
    int countByNickname(String nickname);
}
