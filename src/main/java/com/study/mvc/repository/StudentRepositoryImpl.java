package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<String> studentList = List.of("전주환", "서창현", "예홍렬");

    @Override
    public List<String> getStudnetListAll() {
        return studentList;
    }

    @Override
    public String findStudentByIndex(int index) {
        return studentList.get(index);
    }
}
