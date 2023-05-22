package com.example.springcrmapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestCreateEditDto {

    private String username;
    private String courseName;
    private String comment;
    private String phone;
}
