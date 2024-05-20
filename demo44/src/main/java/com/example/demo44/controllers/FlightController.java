package com.example.demo44.controllers;

import com.example.demo44.enums.FlightStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo44.entities.Flight;
import com.example.demo44.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/add")
    public List<Flight> getFlights(@RequestParam(name = "n", defaultValue = "100") int n) {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();
            flight.setFromAirport("Airport" + random.nextInt(10));
            flight.setToAirport("Airport" + random.nextInt(10));
            flight.setStatus(FlightStatus.valueOf(random.nextBoolean() ? "ONTIME" : "DELAYED"));
            flights.add(flight);
            flightRepository.save(flight);
        }

        return flights;
    }

    @GetMapping("/sorted")
    // Implementazione dell'impaginazione
    public List<Flight> getSortedFlights() {
        return flightRepository.findAll(Sort.by(Sort.Order.asc("fromAirport")));
    }

    @GetMapping("/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightRepository.findFlightsOnTime();
    }

    @GetMapping("/status")
    public List<Flight> getFlightsByStatus(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        return flightRepository.findFlightsByStatuses(Arrays.asList(p1, p2));
    }
}