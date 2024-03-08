package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyRequestDto;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {
    @Autowired
    private DBStudyService dbStudyService;

    // INSERT
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyRequestDto dbStudyRequestDto) {
        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyRequestDto));
    }

    // SELECT 1)
    @GetMapping("/select/study/{id}")
    public ResponseEntity<?> selectStudy(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }

    // SELECT 2)
    @GetMapping("/select/study") // @RequestParam 은 /select/study/?name=홍길동 의 형태
    public ResponseEntity<?> selectStudyName(@RequestParam String name) {
        return ResponseEntity.ok(dbStudyService.findStudyByName(name));
    }

    // SELECT 3)
    @GetMapping("/select/studys")
    public ResponseEntity<?> selectStudyAll() {
        return ResponseEntity.ok(dbStudyService.findAll());
    }

    // DELETE
    @DeleteMapping("/delete/study/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }

    // UPDATE 1) PutMapping
    @PutMapping("/update/study/{id}")
    public ResponseEntity<?> putStudy(
            @PathVariable int id,
            @RequestBody DBStudyRequestDto dbStudyRequestDto) {
        // PUT 은 전체 수정
        return ResponseEntity.ok(dbStudyService.putById(id, dbStudyRequestDto));
    }

    // UPDATE 2) PatchMapping
    @PatchMapping("/update/study/{id}")
    public ResponseEntity<?> patchStudy(
            @PathVariable int id,
            @RequestBody DBStudyRequestDto dbStudyRequestDto) {
        // PATCH 는 부분 수정
        return ResponseEntity.ok(dbStudyService.patchById(id, dbStudyRequestDto));
    }
}
