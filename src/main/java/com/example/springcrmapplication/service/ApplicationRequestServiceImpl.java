package com.example.springcrmapplication.service;

import com.example.springcrmapplication.dto.ApplicationRequestCreateEditDto;
import com.example.springcrmapplication.dto.ApplicationRequestReadDto;
import com.example.springcrmapplication.mapper.ApplicationRequestCreateEditMapper;
import com.example.springcrmapplication.mapper.ApplicationRequestReadMapper;
import com.example.springcrmapplication.repository.ApplicationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationRequestServiceImpl implements ApplicationRequestService{

    private final ApplicationRequestRepository appRequestRepository;
    private final ApplicationRequestReadMapper appRequestReadMapper;
    private final ApplicationRequestCreateEditMapper appRequestCreateEditMapper;

    @Override
    public List<ApplicationRequestReadDto> findAll() {
        return appRequestRepository.findAll().stream()
                .map(appRequestReadMapper::map)
                .toList();
    }

    @Override
    public List<ApplicationRequestReadDto> findAllProcessed() {
        return appRequestRepository.findAllByHandledTrue().stream()
                .map(appRequestReadMapper::map)
                .toList();
    }

    @Override
    public List<ApplicationRequestReadDto> findAllUnprocessed() {
        return appRequestRepository.findAllByHandledFalse().stream()
                .map(appRequestReadMapper::map)
                .toList();
    }

    @Override
    public ApplicationRequestReadDto findById(Long id) {
        return appRequestRepository.findById(id)
                .map(appRequestReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    @Override
    public ApplicationRequestReadDto create(ApplicationRequestCreateEditDto request) {
        return Optional.of(request)
                .map(appRequestCreateEditMapper::map)
                .map(appRequestRepository::save)
                .map(appRequestReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    @Override
    public ApplicationRequestReadDto update(Long id, ApplicationRequestCreateEditDto request) {
        return Optional.of(request)
                .map(appRequestCreateEditMapper::map)
                .map(appRequestRepository::saveAndFlush)
                .map(appRequestReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        appRequestRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void process(Long id, ApplicationRequestCreateEditDto request) {
        Optional.of(request)
                .map(appRequestCreateEditMapper::map)
                .map(applicationRequest -> {
                    applicationRequest.setId(id);
                    applicationRequest.setHandled(true);
                    return appRequestRepository.save(applicationRequest);
                })
                .orElseThrow();
    }

}
