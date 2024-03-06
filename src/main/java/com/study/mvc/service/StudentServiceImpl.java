package com.study.mvc.service;

import com.study.mvc.repository.StudentRepository;
import com.study.mvc.repository.StudentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudnetService {

    private final StudentRepository studentRepository;

    @Override
    public List<Map<String, String>> getStudentList() {
        // 방법1) Map
        List<Map<String, String>> studentMapList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudnetListAll();
        for(String studentName : studentList) {
            studentMapList.add(Map.of("name", studentName));
        }
        return studentMapList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentByIndex(index);
        return Map.of("name", studentName);
    }

//    @Autowired()
//    @Qualifier("studentRepositoryImpl")
//    StudentRepositoryImpl studentRepositoryImpl;
//
//    @Override
//    public List<String> getStudentList() {
//        return studentRepositoryImpl.getStudnetListAll();
//    }
//
//    @Override
//    public String getStudent(int index) {
//        return studentRepositoryImpl.findStudentByIndex(index);
//    }
}
