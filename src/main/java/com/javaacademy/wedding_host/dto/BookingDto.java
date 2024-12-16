package com.javaacademy.wedding_host.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Integer monthNumber;
    private Integer dayNumber;
    private Boolean booked;
}
