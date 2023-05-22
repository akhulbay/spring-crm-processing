package com.example.springcrmapplication.repository;

import com.example.springcrmapplication.dto.ApplicationRequestReadDto;
import com.example.springcrmapplication.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {

    List<ApplicationRequest> findAllByHandledFalse();
    List<ApplicationRequest> findAllByHandledTrue();
}
