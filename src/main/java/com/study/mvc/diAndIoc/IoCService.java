package com.study.mvc.diAndIoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@RequiredArgsConstructor
public class IoCService {

    @Autowired
    private IoCRepository ioCRepository;

//    private final IoCRepository ioCRepository; // final 상수는 무조건 한번 초기화 됨 @RequiredArgsConstructor 와 세트

    public String getJson() throws JsonProcessingException {
        Map<String, String> nameMap = ioCRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(nameMap); // Map -> JSON 형태의 문자열 변환
    }
}
