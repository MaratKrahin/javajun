package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> filter(List<Flight> flights, IFlightFilter iFlightFilter);
}
