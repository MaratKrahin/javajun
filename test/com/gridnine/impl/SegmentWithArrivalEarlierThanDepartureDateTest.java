package com.gridnine.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.impl.SegmentWithArrivalEarlierThanDepartureDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class SegmentWithArrivalEarlierThanDepartureDateTest {
    private final SegmentWithArrivalEarlierThanDepartureDate filter = new SegmentWithArrivalEarlierThanDepartureDate();

    @Test
    void test() {
        var segment = new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().minusHours(1));
        var flight = new Flight(List.of(segment));
        var result = filter.filter(List.of(flight));
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void test1() {
        var segment = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1));
        var flight = new Flight(List.of(segment));
        var result = filter.filter(List.of(flight));
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void test2() {
        var segment = new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().minusHours(1));
        var segment1 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().minusHours(1));
        var flight = new Flight(List.of(segment));
        var flight1 = new Flight(List.of(segment1));
        var result = filter.filter(List.of(flight, flight1));
        Assertions.assertEquals(2, result.size());
    }
}
