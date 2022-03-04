package com.example.assessment.service;

import com.example.assessment.entity.Flight;
import com.example.assessment.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Component
@Scope("singleton")
public class FlightServiceImpl implements FlightService{

    //Inyecta FlightRepository
    @Autowired
    private FlightRepository flightRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Flight> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Flight> findById(Long idFlight) {
        return flightRepository.findById(idFlight);
    }

    @Override
    @Transactional
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public void deleteById(Long idFlight) {
        flightRepository.deleteById(idFlight);
    }
}
