package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.BookingDto;
import com.javaacademy.wedding_host.dto.CreateBookingDto;
import com.javaacademy.wedding_host.entity.Booking;
import com.javaacademy.wedding_host.mapper.BookingMapper;
import com.javaacademy.wedding_host.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public List<BookingDto> findAllByMonth(Integer monthNumber) {
        List<Booking> entites = bookingRepository.findAllByMonth(monthNumber);
        return bookingMapper.toDtos(entites);
    }

    public Integer getCountBookedDays(Integer monthNumber) {
        return bookingRepository.findAllByMonth(monthNumber).size();
    }

    public void createBooking(CreateBookingDto dto) {
        Booking entity = bookingMapper.toEntity(dto);
        bookingRepository.save(entity);
    }
}
