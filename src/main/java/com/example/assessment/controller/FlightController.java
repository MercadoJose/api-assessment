package com.example.assessment.controller;

import com.example.assessment.entity.Flight;
import com.example.assessment.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Crea nuevo vuelo
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Flight flight){
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
    }

    // Lee un vuelo por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long idFlight){
        Optional<Flight> oFlight = flightService.findById(idFlight);
        if (!oFlight.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oFlight);
    }

    // Actualizar un vuelo
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Flight flightDetails, @PathVariable(value = "id") Long idFlight){
        Optional<Flight> flight = flightService.findById(idFlight);
        if (!flight.isPresent()){
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(flightDetails, destination.get());
        flight.get().setAirline(flightDetails.getAirline());
        flight.get().setSeatNumber(flightDetails.getSeatNumber());
        flight.get().setDepartureDate(flightDetails.getDepartureDate());
        flight.get().setArrivalDate(flightDetails.getArrivalDate());
        flight.get().setIdDestination(flightDetails.getIdDestination());
        flight.get().setIdUser(flightDetails.getIdUser());

        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight.get()));
    }

    //Eliminar un vuelo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long idFlight){
        Optional<Flight> flight = flightService.findById(idFlight);
        if (!flight.isPresent()){
            return ResponseEntity.notFound().build();
        }

        flightService.deleteById(idFlight);
        return ResponseEntity.ok().build();
    }

    // Lee todos los vuelos
    @GetMapping
    public List<Flight> readAll(){
        List<Flight> flights = StreamSupport
                .stream(flightService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return flights;
    }
}
