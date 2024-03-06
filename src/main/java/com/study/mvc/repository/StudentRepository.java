package com.study.mvc.repository;

import java.util.List;

public interface StudentRepository {
    public List<String> getStudnetListAll();
    public String findStudentByIndex(int index);
}
