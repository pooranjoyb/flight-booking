package com.flight.flight_booking.repository;

import com.flight.flight_booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BookingRepository extends JpaRepository<Booking, Long> {
}
