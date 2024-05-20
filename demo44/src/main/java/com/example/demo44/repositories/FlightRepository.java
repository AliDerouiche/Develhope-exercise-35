package com.example.demo44.repositories;


import com.example.demo44.entities.Flight;
import com.example.demo44.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatus flightStatus);

    @Query("SELECT flight FROM Flight flight WHERE flight.fromAirport = :airport")
    List<Flight> findFlightsByDepartureAirport(@Param("airport") String airport);

    @Query("SELECT flight FROM Flight flight WHERE flight.status = 'ONTIME'")
    List<Flight> findFlightsOnTime();

    @Query("SELECT flight FROM Flight flight WHERE flight.status IN (:statuses)")
    List<Flight> findFlightsByStatuses(@Param("statuses") List<String> statuses);
}