package com.flight.flight_booking.service;

import com.flight.flight_booking.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);

    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    void deleteBooking(Long id);
}


