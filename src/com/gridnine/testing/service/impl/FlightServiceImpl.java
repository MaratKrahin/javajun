package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightService;
import com.gridnine.testing.service.IFlightFilter;

import java.util.List;

public class FlightServiceImpl implements FlightService {

    @Override
    public List<Flight> filter(List<Flight> flights, IFlightFilter iFlightFilter) {
        return iFlightFilter.filter(flights);
    }

}
