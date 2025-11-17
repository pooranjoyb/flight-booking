package com.flight.flight_booking.service.impl;

import com.flight.flight_booking.model.Passenger;
import com.flight.flight_booking.repository.PassengerRepository;
import com.flight.flight_booking.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    // dependency-injection
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger Not Found"));
    }

    @Override
    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger Not Found"));

        existingPassenger.setEmail(passenger.getEmail());
        existingPassenger.setName(passenger.getName());
        existingPassenger.setPhone(passenger.getPhone());

        return passengerRepository.save(existingPassenger);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
