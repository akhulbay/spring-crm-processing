package com.example.springcrmapplication.mapper;

import com.example.springcrmapplication.dto.ApplicationRequestReadDto;
import com.example.springcrmapplication.model.ApplicationRequest;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRequestReadMapper implements Mapper<ApplicationRequest, ApplicationRequestReadDto>{
    @Override
    public ApplicationRequestReadDto map(ApplicationRequest object) {
        return new ApplicationRequestReadDto(
                object.getId(),
                object.getUsername(),
                object.getCourseName(),
                object.getComment(),
                object.getPhone(),
                object.getHandled()
        );
    }
}
