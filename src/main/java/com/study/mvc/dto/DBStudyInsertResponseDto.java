package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DBStudyInsertResponseDto {
    private int id;
    private String name;
    private int age;
    private boolean successStatus;
    private int successCount;
}
