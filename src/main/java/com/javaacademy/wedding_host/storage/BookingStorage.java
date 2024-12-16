package com.javaacademy.wedding_host.storage;

import com.javaacademy.wedding_host.entity.Booking;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BookingStorage {
    @Getter
    private final Map<Integer, SortedSet<Booking>> data = new ConcurrentHashMap<>();

}
