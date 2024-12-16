package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.entity.Booking;
import com.javaacademy.wedding_host.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Component
@RequiredArgsConstructor
public class BookingRepository {
    private final BookingStorage storage;

    public List<Booking> findAllByMonth(Integer monthNumber) {
        SortedSet<Booking> bookings = storage.getData().get(monthNumber);
        if (bookings == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(bookings);
    }

    public void save(Booking entity) {
        Map<Integer, SortedSet<Booking>> data = storage.getData();
        int monthNumber = entity.getDate().getMonthValue();
        SortedSet<Booking> monthData = data.getOrDefault(monthNumber, new TreeSet<>());
        monthData.add(entity);
        data.put(monthNumber, monthData);
    }
}
