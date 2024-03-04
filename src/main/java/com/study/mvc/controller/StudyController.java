package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller // 서블릿 파일을 만든다
public class StudyController {
//    @GetMapping("/hello") // http://localhost:8080/hello
//    public ModelAndView helloPage() {
//        Map<String, Object> model = new HashMap<>();
//        model.put("name1", "홍길동1");
//        model.put("name2", "홍길동2");
//        model.put("name3", "홍길동3");
//        model.addAttribute("name1", "홍길동1");
//        model.addAttribute("name2", "홍길동2");
//        model.addAttribute("name3", "홍길동3");
//        return new ModelAndView("hello", model); // html 파일명을 찾아서 해당 Get 요청 주소에 렌더링되게 함
//    }

    // MVC
//    @GetMapping("/hello") // http://localhost:8080/hello
//    public ModelAndView helloPage(Model model) {
//        model.addAttribute("name1", "홍길동1");
//        model.addAttribute("name2", "홍길동2");
//        model.addAttribute("name3", "홍길동3");
//        return new ModelAndView("hello"); // html 파일명을 찾아서 해당 Get 요청 주소에 렌더링되게 함
//    }

    @GetMapping("/hello") // http://localhost:8080/hello
    public ModelAndView helloPage(Model model) {
        HelloModel helloModel = HelloModel.builder()
                .name1("홍길동1")
                .name2("홍길동2")
                .name3("홍길동3")
                .build();
        model.addAttribute("helloModel", helloModel);
        return new ModelAndView("hello"); // html 파일명을 찾아서 해당 Get 요청 주소에 렌더링되게 함
    }

//    @GetMapping("/test")
//    public String testPage(Model model) {
//        model.addAttribute("age", 32);
//        return "test";
//    }

    // REST
    @GetMapping("/test")
    @ResponseBody
    public Map<String, Object> testPage() {
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }

}
