package com.example.assessment.controller;

import com.example.assessment.entity.Destination;
import com.example.assessment.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    // Crea nuevo destino
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Destination destination){
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationService.save(destination));
    }

    // Lee un destino por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long idDestination){
        Optional<Destination> oDes = destinationService.findById(idDestination);
        if (!oDes.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oDes);
    }

    // Actualizar un destino
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Destination desDetails, @PathVariable(value = "id") Long idDestination){
        Optional<Destination> destination = destinationService.findById(idDestination);
        if (!destination.isPresent()){
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(desDetails, destination.get());
        destination.get().setDesCountry(desDetails.getDesCountry());
        destination.get().setDesLocation(desDetails.getDesLocation());

        return ResponseEntity.status(HttpStatus.CREATED).body(destinationService.save(destination.get()));
    }

    //Eliminar un destino
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long idDestination){
        Optional<Destination> destination = destinationService.findById(idDestination);
        if (!destination.isPresent()){
            return ResponseEntity.notFound().build();
        }

        destinationService.deleteById(idDestination);
        return ResponseEntity.ok().build();
    }

    // Lee todos los destinos
    @GetMapping
    public List<Destination> readAll(){
        List<Destination> destinations = StreamSupport
                .stream(destinationService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return destinations;
    }
}
