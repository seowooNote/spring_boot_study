package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class StudyRestController {

//    @GetMapping("/hello/test")
//    public String hello(HttpServletRequest request) {
//        System.out.println(request.getMethod());
//        // ex) http://localhost:8080/hello/test?name=홍길동
//        System.out.println(request.getParameter("name"));
//        return "Hello";
//    }

//    @GetMapping("/hello/test")
//    public String hello(@RequestParam("name") String n) {
//        System.out.println(n);
//        return "Hello";
//    }

//    @GetMapping("/hello/test")
//    public String hello(@RequestParam String name) {
//        System.out.println(name);
//        return "Hello";
//    }

//    @GetMapping("/hello/test")
//    public String hello(String name) {
//        System.out.println(name);
//        return "Hello";
//    }

//    @GetMapping("/hello/test")
//    public String hello(String name, String age) {
//        System.out.println(name);
//        System.out.println(age);
//        return "Hello";
//    }

//    @GetMapping("/hello/test")
//    public String hello(String name, int age) {
//    // ex) http://localhost:8080/hello/test?name=홍길동&age=32 -> 무조건 name과 age의 값이 요청시 입력해야 됨
//        System.out.println(name);
//        System.out.println(age);
//        return "Hello";
//    }

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) {
    // ex) http://localhost:8080/hello/test?name=홍길동 @NoArgsConstructor
        System.out.println(helloDto);
        return "Hello";
    }
}
