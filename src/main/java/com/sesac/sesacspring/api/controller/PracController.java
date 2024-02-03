package com.sesac.sesacspring.api.controller;

import com.sesac.sesacspring.api.vo.PracVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PracController {
    @GetMapping("/introduce")
    public String getMain(){
        return "practice";
    }
    @GetMapping("/introduce/{param1}")
    public String getIntroduce(
            @PathVariable String param1,
            Model model){
        model.addAttribute("name", param1);
        return "practice2";
    }

    @GetMapping("/introduce2")
    public String getResponse2(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) String age,
            Model model
    ){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "practice2";
    }

//    @PostMapping("/postInfo")
//    public String postInformation(
//            @RequestParam(value = "name", required = false) String a,
//            @RequestParam(value = "gender", required = false) String b,
//            @RequestParam(value = "year", required = false) String c,
//            @RequestParam(value = "interest", required = false) String f,
//            Model model
//    ){
//        model.addAttribute("name", a);
//        model.addAttribute("gender", b);
//        model.addAttribute("year", c);
//        model.addAttribute("interest", f);
//        return "practice3";
//    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody PracVO pracVO){
        return pracVO.getName()+"님 환영합니다.";
    }
}
