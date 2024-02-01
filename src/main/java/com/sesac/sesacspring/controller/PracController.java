package com.sesac.sesacspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/postInfo")
    public String postInformation(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "gender", required = false) String b,
            @RequestParam(value = "year", required = false) String c,
            @RequestParam(value = "month", required = false) String d,
            @RequestParam(value = "day", required = false) String e,
            @RequestParam(value = "interest", required = false) String f,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("gender", b);
        model.addAttribute("year", c);
        model.addAttribute("month", d);
        model.addAttribute("day", e);
        model.addAttribute("interest", f);
        return "practice3";
    }
}
