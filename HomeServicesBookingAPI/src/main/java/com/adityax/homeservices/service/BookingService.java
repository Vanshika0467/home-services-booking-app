package com.adityax.homeservices.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adityax.homeservices.dto.BookingRequest;
import com.adityax.homeservices.dto.BookingResponse;
import com.adityax.homeservices.entity.Booking;
import com.adityax.homeservices.exception.ResourceNotFoundException;
import com.adityax.homeservices.repository.BookingRepository;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;

    private final ServiceCatalogService serviceCatalogService;

    public BookingService(
            BookingRepository bookingRepository,
            ServiceCatalogService serviceCatalogService) {

        this.bookingRepository = bookingRepository;
        this.serviceCatalogService = serviceCatalogService;
    }

    @Transactional
    public BookingResponse create(BookingRequest request) {

        Booking booking = new Booking();

        booking.setService(
                serviceCatalogService.getEntity(request.serviceId())
        );

        booking.setName(request.name().trim());
        booking.setPhone(request.phone());
        booking.setAddress(request.address().trim());
        booking.setDate(request.date());
        booking.setTimeSlot(request.timeSlot());
        booking.setStatus("PENDING");

        Booking savedBooking = bookingRepository.save(booking);

        return toResponse(savedBooking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getAll() {

        return bookingRepository
                .findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private BookingResponse toResponse(Booking booking) {

        return new BookingResponse(
                booking.getId(),
                booking.getService().getId(),
                booking.getService().getName(),
                booking.getName(),
                booking.getPhone(),
                booking.getAddress(),
                booking.getDate(),
                booking.getTimeSlot(),
                booking.getStatus(),
                booking.getCreatedAt()
        );
    }
    
    @Transactional
    public BookingResponse updateBooking(Long id, BookingRequest request) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Booking with id " + id + " was not found."));

        booking.setService(
                serviceCatalogService.getEntity(request.serviceId()));

        booking.setName(request.name().trim());
        booking.setPhone(request.phone());
        booking.setAddress(request.address().trim());
        booking.setDate(request.date());
        booking.setTimeSlot(request.timeSlot());

        Booking updatedBooking = bookingRepository.save(booking);

        return toResponse(updatedBooking);
    }
    
    @Transactional
    public void deleteBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Booking with id " + id + " was not found."));

        bookingRepository.delete(booking);
    }

    @Transactional
    public BookingResponse updateBookingStatus(Long id, String status) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Booking with id " + id + " was not found."));

        if (!List.of("PENDING", "CONFIRMED", "CANCELLED", "COMPLETED")
                .contains(status.toUpperCase())) {
            throw new IllegalArgumentException(
                    "Invalid status. Allowed: PENDING, CONFIRMED, CANCELLED, COMPLETED");
        }

        booking.setStatus(status.toUpperCase());

        Booking updatedBooking = bookingRepository.save(booking);

        return toResponse(updatedBooking);
    }
}
