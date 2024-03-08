package com.study.mvc.entity;

import com.study.mvc.dto.DBStudySelectResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Study {
    private int id;
    private String name;
    private int age;
    private LocalDateTime createDate;

    public DBStudySelectResponseDto toDto() {
        return DBStudySelectResponseDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}
