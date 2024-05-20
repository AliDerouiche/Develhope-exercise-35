package com.example.demo44.enums;

public enum FlightStatus {
    ONTIME, DELAYED, CANCELLED;


    public static FlightStatus toString(String status) {
        return switch (status.toLowerCase()) {
            case "delayed" -> FlightStatus.DELAYED;
            case "cancelled" -> FlightStatus.CANCELLED;
            default -> FlightStatus.ONTIME;
        };


    }
}