package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.IFlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThan2HoursOnTheGround implements IFlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toHours() >= 2))
                .collect(Collectors.toList());

    }

}
