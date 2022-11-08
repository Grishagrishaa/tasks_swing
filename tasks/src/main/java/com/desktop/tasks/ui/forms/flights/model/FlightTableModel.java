package com.desktop.tasks.ui.forms.flights.model;

import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.ui.forms.shared.model.DefaultTableModel;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FlightTableModel extends DefaultTableModel<Flight> {
    @Value("${app.eventTime}")
    private String EVENT_TIME_MESSAGE;
    @Value("${app.priority}")
    private String PRIORITY_MESSAGE;
    @Value("${app.departureAirport}")
    private String DER_AIRPORT_MESSAGE;
    @Value("${app.arrivingAirport}")
    private String ARR_AIRPORT_MESSAGE;
    @Value("${app.arrivingTime}")
    private String ARR_TIME_MESSAGE;

    private static final int EVENT_TIME_INDEX = 0;
    private static final int PRIORITY_INDEX = 1;
    private static final int DER_AIRPORT_INDEX = 2;
    private static final int ARR_AIRPORT_INDEX = 3;
    private static final int ARR_TIME_INDEX = 4;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                EVENT_TIME_MESSAGE,
                PRIORITY_MESSAGE,
                DER_AIRPORT_MESSAGE,
                ARR_AIRPORT_MESSAGE,
                ARR_TIME_MESSAGE};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Flight flight = entities.get(rowIndex);

        switch (columnIndex) {
            case EVENT_TIME_INDEX:
                return flight.getEventTime();
            case PRIORITY_INDEX:
                return flight.getPriority();
            case DER_AIRPORT_INDEX:
                return flight.getDepartureAirport();
            case ARR_AIRPORT_INDEX:
                return flight.getArrivingAirPort();
            case ARR_TIME_INDEX:
                return flight.getArrivingTime();
            default:
                return Strings.EMPTY;
        }
    }

}
