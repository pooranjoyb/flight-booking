package com.flight.flight_booking.service;

import com.flight.flight_booking.model.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger passenger);

    List<Passenger> getAllPassengers();

    Passenger getPassengerById(Long id);

    Passenger updatePassenger(Long id, Passenger passenger);

    void deletePassenger(Long id);
}
