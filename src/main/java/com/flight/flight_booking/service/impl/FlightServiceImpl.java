package com.flight.flight_booking.service.impl;

import com.flight.flight_booking.model.Flight;
import com.flight.flight_booking.repository.FlightRepository;
import com.flight.flight_booking.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    // constructor-injection -> jpa repository takes control
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }


    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight updateFlight(Long id, Flight flight) {

        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setDeparture(flight.getDeparture());
        existingFlight.setArrival(flight.getArrival());
        existingFlight.setDate(flight.getDate());
        existingFlight.setAvailableSeats(flight.getAvailableSeats());

        return flightRepository.save(existingFlight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
