package com.study.mvc.service;

import com.study.mvc.dto.StudentExDto;
import com.study.mvc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl2 implements StudnetService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentExDto> getStudentList() {
        // 방법2) 객체(StudentExDto)
        List<StudentExDto> studentExDtoList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudnetListAll();
        for(String studentName : studentList) {
            studentExDtoList.add(new StudentExDto(studentName));
        }
        return studentExDtoList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentByIndex(index);
        return new StudentExDto(studentName);
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
