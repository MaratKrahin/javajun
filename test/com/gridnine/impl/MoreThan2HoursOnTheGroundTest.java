package com.gridnine.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.impl.MoreThan2HoursOnTheGround;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class MoreThan2HoursOnTheGroundTest {
    private final MoreThan2HoursOnTheGround filter = new MoreThan2HoursOnTheGround();


    @Test
    void test() {

        var segment = new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1));
        var segment1 = new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(2));
        var segment2 = new Segment(LocalDateTime.now().minusMinutes(1), LocalDateTime.now().minusMinutes(1));

        var flight = new Flight(List.of(segment, segment1));
        var flight1 = new Flight(List.of(segment2));

        var result = filter.filter(List.of(flight, flight1));
        Assertions.assertEquals(1, result.size());
    }
}
