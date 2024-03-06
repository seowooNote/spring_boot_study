package com.study.mvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.repository.CarRepository;
import com.study.mvc.repository.CarRepositoryImpl2;
//import com.study.mvc.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final String componentName = "a";

//    @Autowired
//    private TestUtil testUtil;

    @Autowired
    @Qualifier(componentName)
//    @Qualifier("a")
//    private CarRepository carRepository = new CarRepositoryImpl2();
//    private CarRepository carRepository = new CarRepositoryImpl1();
//    private CarRepository carRepository;
    private CarRepository carRepository;

    @Override
    public String getCarNames() {
        return String.join(", ", carRepository.getCarNames()); // List -> 문자열 변환 (", " 쉼표로 구분해서)
        // 출력 예시 => 문자열 : Audi, Toyota
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
