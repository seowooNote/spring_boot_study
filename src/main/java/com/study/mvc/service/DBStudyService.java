package com.study.mvc.service;

import com.study.mvc.dto.DBStudyInsertResponseDto;
import com.study.mvc.dto.DBStudyRequestDto;
import com.study.mvc.dto.DBStudySelectResponseDto;
import com.study.mvc.entity.Study;
import com.study.mvc.repository.DBStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {
    @Autowired
    private DBStudyRepository dbStudyRepository;


    public DBStudyInsertResponseDto createStudy(DBStudyRequestDto dbStudyRequestDto) {
        // 방법1) Allargs
        // Study stuy = new Study(0,dbStudyRequestDto.getName(), dbStudyRequestDto.getAge(), null);

        // 방법2) Noargs
        // Study Study = new Study();
        // Study.setName(dbStudyRequestDto.getName());
        // Study.setAge(dbStudyRequestDto.getAge());

        // 중복체크
        Study findStudy = dbStudyRepository.findStudyByName(dbStudyRequestDto.getName());
        if(findStudy != null) {
            return DBStudyInsertResponseDto.builder()
                    .successStatus(false)
                    .build();
        }

        // 방법3) Builder
        Study study = Study.builder()
                .name(dbStudyRequestDto.getName())
                .age(dbStudyRequestDto.getAge())
                .build();
        int successCount = dbStudyRepository.save(study);

        DBStudyInsertResponseDto dbStudyInsertResponseDto = DBStudyInsertResponseDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();

        return dbStudyInsertResponseDto;
    }

    public DBStudySelectResponseDto findStudyById(int id) {

        Study study = dbStudyRepository.findStudyById(id);

        System.out.println(study);

        DBStudySelectResponseDto dbStudySelectResponseDto = DBStudySelectResponseDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .build();

        return dbStudySelectResponseDto;
    }

    public DBStudySelectResponseDto findStudyByName(String name) {

        Study study = dbStudyRepository.findStudyByName(name);

        return study == null ? null : study.toDto();
    }

    public List<DBStudySelectResponseDto> findAll() {
        List<DBStudySelectResponseDto> responseDtoList = new ArrayList<>();
        List<Study> studyList = dbStudyRepository.findAll();
        for(Study study : studyList) {
            responseDtoList.add(study.toDto());
        }
        return responseDtoList;
    }

    // stream 쓰는 버전 findAll
    public List<DBStudySelectResponseDto> findAll2() {
        return dbStudyRepository.findAll()
                .stream()
                .map(Study::toDto)
                .collect(Collectors.toList());
    }

    public int deleteById(int id) {
        return dbStudyRepository.deleteById(id);
    }

    public int putById(int id, DBStudyRequestDto dbStudyRequestDto) {
        Study study = dbStudyRequestDto.toEntity(id);
        return dbStudyRepository.putById(study);
    }

    public int patchById(int id, DBStudyRequestDto dbStudyRequestDto) {
        Study study = dbStudyRequestDto.toEntity(id);
        return dbStudyRepository.patchById(study);
    }

}
