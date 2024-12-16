package com.javaacademy.wedding_host.entity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class Booking implements Comparable<Booking> {
    @NonNull
    private LocalDate date;

    @Override
    public int compareTo(Booking o) {
        if (o == null) {
            return 1;
        }
        return this.date.compareTo(o.date);
    }
}
