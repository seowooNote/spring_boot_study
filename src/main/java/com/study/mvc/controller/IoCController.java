package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import com.study.mvc.diAndIoc.IoCService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RequiredArgsConstructor
public class IoCController {

    // DI
//    private DiService diService;
//
//    public IoCController() {
//        DiRepository diRepository = new DiRepository();
//        diService = new DiService(diRepository);
//    }

//    @GetMapping("/ioc")
//    public ResponseEntity<?> iocTest() {
//        int total = diService.getTotal();
//        double avg = diService.getAverage();
//        Map<String, Object> map =
//                Map.of(
//                        "total", total,
//                        "avg" , avg
//                );
//        return ResponseEntity.ok(map);
//    }

    // IOC
    @Autowired
    private IoCService ioCService;

//    private final IoCService ioCService;

    @GetMapping("/ioc")
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
        String json = ioCService.getJson();
        return ResponseEntity.ok(json);
    }
}
