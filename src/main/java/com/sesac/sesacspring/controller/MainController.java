package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController // @Controller + @ResponseBody
public class MainController {
    
    // Get
    // 매개변수를 넘겨받는 방법
    // 1. /test?id=123 => @RequestParam
    // 2. /test/123 => @PathVariable 
    @GetMapping("/")
    public String getMain(){
        return "request";
    }
    @GetMapping("/get/response1")
    // ?key=value : @RequestParam 쓰는 이유
    // ?name=123&id=11&age=abc
    // - string qyery(?뒤의 값)에서 key("name")에 대한
    // value("112")를 변수 ("i")에 매핑
    // required=true 기본값 => 요청 url에서 설정한 key가 필수로 있어야 함.
    // @RequestParam은 기본값으로 required = true 받고 있음.
    public String getResponse(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "response";
    }
    @GetMapping("/get/response2")
    // ?search=검색어
    // ?search=검색어&hashtag=코딩
    // required=false옵션 @RequestParam(value = "name", required = false)
    // - query String에서 특정 key를 옵셔널하게 받아야 하는 경우
    // ex) 검색할 때(검색어(필수) 해시태그(선택))
    // @RequestParam(value="search") String search, @RequestParam(value="hashtag", required=false) String hashtag
    public String getResponse2(
            @RequestParam(value = "name", required = false) String name,
            Model model
    ){
        model.addAttribute("name", name);
        return "response";
    }
    @GetMapping("/get/response3/{param1}/{param2}")
    // url 안에 넣을 때 @PathVariable
    /*
    - 기본적으로 경로 변수의 값을 필수로 받아야 하기 때문 (보내지 않으면 404에러 발생)
    -/test/{id} 형식의 URL 경로로 데이터를 넘겨줄 때 받는 방법
     */
    public String getResponse3(
            @PathVariable String param1,
            @PathVariable(value = "param2") String age,
            Model model
    ){
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "response";
    }

    // pathvariable을 보낼 때 선택적으로 처리해야 한다면 
    @GetMapping({"/get/response4/{param1}", "/get/response4/{param1}/{param2}"})
    public String getResponse4(
            @PathVariable String param1,
            @PathVariable(required = false, value = "param2") String age,
            Model model){
        // 중요! optional한 parameter는 맨 뒤에 오도록 설정
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "response";
    }

    // post 방식 -@RequestParam
    @PostMapping("/post/response1")
    public String postResponse1(
            @RequestParam(value = "name") String a,
            @RequestParam(value = "age") String b,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return "response";
    }
    @PostMapping("/post/response2")
    public String postResponse2(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "age", required = false) String b,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return "response";
    }
    // @ResponseBody:
    // - 요청을 보냈을 때 응답을 json 형태로 리턴하는 것(serialize)
    // express res.send와 유사
    @PostMapping("/post/response3")
    @ResponseBody
    public String postResponse3(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "age", required = false) String b,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return a + "-" + b;
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    // @ModelAttribute: HTML 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑
    // 생략해도 되는 어노테이션!
    // 매핑 = SETTER 함수 실행
    // ?name=홍길식&age=10 -> setName("홍길동") setAge("10")
    public String dtoResponse1(@ModelAttribute UserDTO userDTO){
        // DTO: getter와 setter가 있는 객체
        // Get 방식에서 DTO 객체로 담아서 값이 받아지는구나.
        return userDTO.getName() + " " + userDTO.getAge();
    }

    // @RequestBody: 요청의 본문에 있는 데이터(body)를 받는 친구
    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(@RequestBody UserDTO userDTO){
        return userDTO.getName() + " " + userDTO.getAge();
    }

    // form 파일 업로드 할 때 <form enctype="multipart/form-data">
    // 일반 폼 전송 -> www-x-form-urlencoded => 쿼리 매개변수
    // 일반폼전송 -> RequestBody 값을 X
    // RequestBody는 요청의 본문에 있는 데이터(body)를 실행할 수 있기 때문에
    // json, xml일 때만 실행이 가능
    // application/json

    // 일반 폼전송 - DTO(getter, setter 모두 있는 친구)
    // 1) 어노테이션 없이 DTO를 받을 경우 -> O
    // 2) @ModelAttribute DTO 받을 경우 -> O
    // 3) @RequestBody DTO 받을 경우 -> 오류 
    
    // 일반 폼 전송은  www-x-form-urlencoded 형식이기 때문에
    // get이든 post든 요청의 본문에 데이터가 들어가는 게 아닌 폼 데이터 형태로
    // url로 데이터가 전송됨 => 즉, 일반 폼전송은 RequestBody 사용 불가
}
