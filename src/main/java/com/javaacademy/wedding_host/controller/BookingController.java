package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.BookingDto;
import com.javaacademy.wedding_host.dto.CountBookingDaysDto;
import com.javaacademy.wedding_host.dto.CreateBookingDto;
import com.javaacademy.wedding_host.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/month/{monthNumber}")
    public List<BookingDto> getAllByMonth(@PathVariable Integer monthNumber) {
        return bookingService.findAllByMonth(monthNumber);
    }

    @GetMapping("/month/{monthNumber}/free")
    public CountBookingDaysDto getCountBookingDays(@PathVariable Integer monthNumber) {
        return new CountBookingDaysDto(bookingService.getCountBookedDays(monthNumber));
    }

    @PostMapping
    @ResponseStatus(code = CREATED)
    public void create(@RequestBody CreateBookingDto dto) {
        bookingService.createBooking(dto);
    }
}
