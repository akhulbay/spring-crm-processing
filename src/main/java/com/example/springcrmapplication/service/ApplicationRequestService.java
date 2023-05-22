package com.example.springcrmapplication.service;

import com.example.springcrmapplication.dto.ApplicationRequestCreateEditDto;
import com.example.springcrmapplication.dto.ApplicationRequestReadDto;

import java.util.List;

public interface ApplicationRequestService {

    List<ApplicationRequestReadDto> findAll();

    List<ApplicationRequestReadDto> findAllProcessed();
    List<ApplicationRequestReadDto> findAllUnprocessed();

    ApplicationRequestReadDto findById(Long id);

    ApplicationRequestReadDto create(ApplicationRequestCreateEditDto request);

    ApplicationRequestReadDto update(Long id, ApplicationRequestCreateEditDto request);

    void delete(Long id);

    void process(Long id, ApplicationRequestCreateEditDto request);

}
