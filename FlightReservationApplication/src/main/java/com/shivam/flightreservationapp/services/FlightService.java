package com.shivam.flightreservationapp.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.flightreservationapp.entities.Flight;
import com.shivam.flightreservationapp.repositories.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> searchFlights(String origin, String destination, String departureDate) {
        LocalDate date = LocalDate.parse(departureDate);
        return flightRepository.findByOriginAndDestinationAndDepartureDate(origin, destination, date);
    }
    

    
    
}

