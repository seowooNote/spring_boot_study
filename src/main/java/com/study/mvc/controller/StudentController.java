package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    // JSON 일때
    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException { // @RequestBody POST 요청시 매개변수에 달아야 함!!!(단 JSON만 됨) JSON이 아닐경우 없애고 그냥 쓰면 됨
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;
        if(students != null) {
            if(!students.isBlank()) {
                ObjectMapper studentsCookie = new ObjectMapper();
                studentList = studentsCookie.readValue(students, List.class);
                lastId = studentList.get(studentList.size() - 1).getStudentId();
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String newStudents = newStudentList.writeValueAsString(studentList);
        ResponseCookie responseCookie = ResponseCookie
                .from("students", newStudents)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .build();
        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }

    // JSON 이 아닐때
//    @PostMapping("/student")
//    public ResponseEntity<?> addStudent(Student student) { // @RequestBody POST 요청시 매개변수에 달아야 함!!!(단 JSON만 됨) JSON이 아닐경우 없애고 그냥 쓰면 됨
//        return ResponseEntity.created(null).body(student);
//    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudent(StudentReqDto studentReqDto) {
        System.out.println(studentReqDto);

//        return ResponseEntity.ok().body(studentReqDto.toResDto());
        return ResponseEntity.badRequest().header("test", "header_test").body(studentReqDto.toResDto()); // Status Code : 400
    }

//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<?> getStudent(@PathVariable("studentId") int studentId) {
//        List<Student> studentList = List.of(
//                new Student(1, "홍길동1"),
//                new Student(2, "홍길동2"),
//                new Student(3, "홍길동3"),
//                new Student(4, "홍길동4")
//        );
//    }

//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
//        List<Student> studentList = List.of(
//                new Student(1, "홍길동1"),
//                new Student(2, "홍길동2"),
//                new Student(3, "홍길동3"),
//                new Student(4, "홍길동4")
//        );
//
//        Student findStudent = null;
//        for(Student student : studentList) {
//            if(student.getStudentId() == studentId) {
//                findStudent = student;
//            }
//        }
//
//        if (findStudent == null) {
//            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
//        }
//
//        return ResponseEntity.ok().body(findStudent);
//    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
        List<Student> studentList = List.of(
                new Student(1, "홍길동1"),
                new Student(2, "홍길동2"),
                new Student(3, "홍길동3"),
                new Student(4, "홍길동4")
        );

        return studentList.size() <= studentId ?
            ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다.")) :
            ResponseEntity.ok().body(studentList.get(studentId - 1));
    }

//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
//        List<Student> studentList = List.of(
//                new Student(1, "홍길동1"),
//                new Student(2, "홍길동2"),
//                new Student(3, "홍길동3"),
//                new Student(4, "홍길동4")
//        );
//
//        Student findStudent = null;
//        for(Student student : studentList) {
//            if(student.getStudentId() == studentId) {
//                findStudent = student;
//            }
//        }
////        studentList.stream().filter(student -> student.getStudentId() == studentId).collect(Collectors.toList()).get(0);
//        Optional<Student> optionalStudent = studentList.stream().filter(student -> student.getStudentId() == studentId).findFirst();
//        if(optionalStudent.isEmpty()) {
//            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
//        }
//        findStudent = optionalStudent.get();
//
//        if (findStudent == null) {
//            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));
//        }
//
//        return ResponseEntity.ok().body(findStudent);
//    }
}
