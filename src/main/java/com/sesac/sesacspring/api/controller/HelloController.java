package com.sesac.sesacspring.api.controller;

import com.sesac.sesacspring.api.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Controller //해당 클래스가 Controller의 역할을 하는 클래스라는 것을 Spring Container에 알려준다.
public class HelloController {
    @GetMapping("/hi") //URL을 매핑시켜주는 친구 클라이언트가 /hi 라는 경로로 Get method로 접근한다면 아래 메소드를  실행시켜라.
    public String getHi(Model model){
        // Model: Controller 안에 메서드가 파라미터로 받을 수 있는 객체 중 하나
        // Model안에 정보를 담아서 view로 전달
        // IoC: 개발자가 직접 model 생성 X
        model.addAttribute("name", "eun");
        model.addAttribute("key", "dan");

        ArrayList<String> items = new ArrayList<>();
        items.add("a");
        items.add("b");
        items.add("c");
        items.add("d");
        items.add("e");
        model.addAttribute("items", items);

        char[] alphabetArray = new char[26];
        char alphabet = 'A';
        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = alphabet;
            alphabet++;
        }
        model.addAttribute("item2", alphabetArray);

        return "hi"; //템플릿 파일의 이름
    }
    @GetMapping("/prac")
    public String getPrac(Model model){
        LinkedHashMap<String, Integer> person = new LinkedHashMap<>();
        person.put("kim", 10);
        person.put("lee", 20);
        person.put("hong", 30);
        person.put("park", 40);
        person.put("shin", 50);
        model.addAttribute("person", person);

        ArrayList<Person> person2 = new ArrayList<>();
        person2.add(new Person("kim", 10));
        person2.add(new Person("lee", 20));
        person2.add(new Person("hong", 30));
        person2.add(new Person("park", 40));
        person2.add(new Person("shin", 60));
        model.addAttribute("person2", person2);

        Person p = new Person("h", 10);
        System.out.println(p.getName());

        return "prac";
    }
}
