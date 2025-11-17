package com.flight.flight_booking.repository;

import com.flight.flight_booking.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
