package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightService;
import com.gridnine.testing.service.impl.DepartureUntilTheCurrentTime;
import com.gridnine.testing.service.impl.FlightServiceImpl;
import com.gridnine.testing.service.impl.MoreThan2HoursOnTheGround;
import com.gridnine.testing.service.impl.SegmentWithArrivalEarlierThanDepartureDate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightsList = FlightBuilder.createFlights();
        FlightService flightService = new FlightServiceImpl();


//     как показательный пример сервиса (можно не создавая класс, передать какую-либо вариацию фильтрации)
        flightService.filter(flightsList, flights -> flights.stream().filter(Objects::nonNull).collect(Collectors.toList()));

        System.out.println("вылет до текущего момента времени: \n"
                + flightService.filter(flightsList,  new DepartureUntilTheCurrentTime()));
        System.out.println("интервал на земле превышает два часа: \n"
                + flightService.filter(flightsList,  new MoreThan2HoursOnTheGround()));
        System.out.println("сегменты с датой прилёта раньше даты вылета: \n"
                        + flightService.filter(flightsList,  new SegmentWithArrivalEarlierThanDepartureDate()));;
    }
}
