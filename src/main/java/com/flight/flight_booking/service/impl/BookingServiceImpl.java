package com.flight.flight_booking.service.impl;

import com.flight.flight_booking.model.Booking;
import com.flight.flight_booking.model.Flight;
import com.flight.flight_booking.model.Passenger;
import com.flight.flight_booking.repository.BookingRepository;
import com.flight.flight_booking.repository.FlightRepository;
import com.flight.flight_booking.repository.PassengerRepository;
import com.flight.flight_booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              PassengerRepository passengerRepository,
                              FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;

    }

    @Override
    public Booking createBooking(Booking booking) {

        Passenger passenger = passengerRepository.findById(booking.getPassenger().getId())
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        Flight flight = flightRepository.findById(booking.getFlight().getId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("Seats not Available");
        }

        // decrease seat
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        Booking newBooking = new Booking();
        newBooking.setPassenger(passenger);
        newBooking.setFlight(flight);
        newBooking.setBookingData(LocalDateTime.now());

        return bookingRepository.save(newBooking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Booking not found!")));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
