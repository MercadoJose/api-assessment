package com.example.assessment.service;

import com.example.assessment.entity.Destination;
import com.example.assessment.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DestinationService {

    Iterable<Destination> findAll();
    Page<Destination> findAll(Pageable pageable);
    Optional<Destination> findById(Long idDestination);
    Destination save(Destination destination);
    void deleteById(Long idDestination);
}
