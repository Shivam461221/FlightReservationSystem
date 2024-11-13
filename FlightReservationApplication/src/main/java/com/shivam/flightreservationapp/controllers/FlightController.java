package com.shivam.flightreservationapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.flightreservationapp.entities.Flight;
import com.shivam.flightreservationapp.services.FlightService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/api/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("/create")
	public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
		Flight createdFlight = flightService.createFlight(flight);
		return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> flights = flightService.getAllFlights();
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Flight>> searchFlights(@RequestParam String origin, @RequestParam String destination,
			@RequestParam String departureDate) {
		List<Flight> flights = flightService.searchFlights(origin, destination, departureDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

}
