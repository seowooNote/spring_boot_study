package com.study.mvc.controller;

import com.study.mvc.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
//    @Autowired
//    @Qualifier("studentServiceImpl")
//    private StudentServiceImpl studentServiceImpl;
//
//    @GetMapping("/ex/students")
//    public ResponseEntity<?> students() {
//        return ResponseEntity.ok(studentServiceImpl.getStudentList());
//    }
//
//    @GetMapping("/ex/student/{index}")
//    public ResponseEntity<?> student(@PathVariable int index) {
//        return ResponseEntity.ok(studentServiceImpl.getStudent(index));
//    }

//    @Autowired
//    @Qualifier("studentServiceImpl")
//    StudentServiceImpl studentServiceImpl;
//
//    @GetMapping("/ex/students")
//    public ResponseEntity<?> getStudents() {
//        List<String> list = studentServiceImpl.getStudentList();
//        List<Object> resultList = new ArrayList<>();
//        for(String str : list) {
//            resultList.add(new StudentEx(str));
//        }
//        return ResponseEntity.ok(resultList);
//    }
//
//    @GetMapping("/ex/student/{studentId}")
//    public ResponseEntity<?> getStudent(@PathVariable int studentId){
//        String student = studentServiceImpl.getStudent(studentId);
//        Map<String ,Object> resultList = new HashMap<>();
//
//        if(student != null) {
//            resultList.put("name", student);
//            return ResponseEntity.ok(resultList);
//        } else {
//            resultList.put("Error", "존재하지 않는 학생입니다.");
//        }
//
//        return ResponseEntity.ok(resultList);
//    }
}
