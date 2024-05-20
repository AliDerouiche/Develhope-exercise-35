package com.example.demo44.entities;

import com.example.demo44.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "fromAirport")
    private String fromAirport;

    @Column(name = "toAirport")
    private String toAirport;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FlightStatus status;

    public Flight(String description, String fromAirport, String toAirport) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = FlightStatus.ONTIME;
    }
}
