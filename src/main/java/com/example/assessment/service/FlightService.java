package com.example.assessment.service;

import com.example.assessment.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FlightService {

    Iterable<Flight> findAll();
    Page<Flight> findAll(Pageable pageable);
    Optional<Flight> findById(Long idFlight);
    Flight save(Flight flight);
    void deleteById(Long idFlight);
}
