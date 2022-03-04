package com.example.assessment.service;

import com.example.assessment.entity.Destination;
import com.example.assessment.repository.DestinationRepository;
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
public class DestinationServiceImpl implements DestinationService{

    //Inyecta DestinationRepository
    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Destination> findAll() {
        return destinationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Destination> findAll(Pageable pageable) {
        return destinationRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Destination> findById(Long idDestination) {
        return destinationRepository.findById(idDestination);
    }

    @Override
    @Transactional
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    @Transactional
    public void deleteById(Long idDestination) {
        destinationRepository.deleteById(idDestination);
    }
}
