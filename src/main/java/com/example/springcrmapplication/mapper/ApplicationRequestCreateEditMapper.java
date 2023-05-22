package com.example.springcrmapplication.mapper;

import com.example.springcrmapplication.dto.ApplicationRequestCreateEditDto;
import com.example.springcrmapplication.dto.ApplicationRequestReadDto;
import com.example.springcrmapplication.model.ApplicationRequest;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRequestCreateEditMapper implements Mapper<ApplicationRequestCreateEditDto, ApplicationRequest>{
    @Override
    public ApplicationRequest map(ApplicationRequestCreateEditDto object) {
        return ApplicationRequest.builder()
                .username(object.getUsername())
                .courseName(object.getCourseName())
                .comment(object.getComment())
                .phone(object.getPhone())
                .handled(false)
                .build();
    }
}
