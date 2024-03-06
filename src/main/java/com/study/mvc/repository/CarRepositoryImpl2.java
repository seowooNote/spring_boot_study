package com.study.mvc.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("b")
public class CarRepositoryImpl2 implements CarRepository {

    @Override
    public List<String> getCarNames() {
        return List.of("Audi", "Toyota");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량 : " + carName);
        return 1;
    }
}
