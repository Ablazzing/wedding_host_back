package com.javaacademy.wedding_host.mapper;

import com.javaacademy.wedding_host.dto.BookingDto;
import com.javaacademy.wedding_host.dto.CreateBookingDto;
import com.javaacademy.wedding_host.entity.Booking;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.of;

@Component
public class BookingMapper {
    @Value("${app.booking.year}")
    private Integer year;

    public BookingDto toDto(Booking entity) {
        LocalDate date = entity.getDate();
        return new BookingDto(date.getMonthValue(), date.getDayOfMonth(), true);
    }

    public List<BookingDto> toDtos(List<Booking> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public Booking toEntity(CreateBookingDto dto) {
        return new Booking(of(year, dto.getMonth(), dto.getDay()));
    }
}
