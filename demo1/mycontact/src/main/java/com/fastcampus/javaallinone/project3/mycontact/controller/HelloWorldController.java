package com.fastcampus.javaallinone.project3.mycontact.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller // 스프링에서 관리하는 Controller Bean이라는 표식
//@ResponseBody// API 형식이므로 Response body 어노테이션 표식
// 그런데 이 2개의 어노테이션은 @RestController로 치환가능
//  @Controller+@ResponseBody=@RestController
@RestController
public class HelloWorldController {


    @GetMapping(value = "/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
