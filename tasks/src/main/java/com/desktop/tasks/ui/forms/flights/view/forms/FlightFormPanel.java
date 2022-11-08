package com.desktop.tasks.ui.forms.flights.view.forms;

import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.service.enums.EPriority;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FlightFormPanel extends JPanel  {
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

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);



    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JFormattedTextField eventTimeTF;
    private JComboBox priorityBox;
    private JTextField departureAirportTF;
    private JTextField arrivingAirportTF;
    private JFormattedTextField arrivingTimeTF;

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH));
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel eventTimeLbl = new JLabel(EVENT_TIME_MESSAGE);
        JLabel priorityLbl = new JLabel(PRIORITY_MESSAGE);
        JLabel departureAirportLbl = new JLabel(DER_AIRPORT_MESSAGE);
        JLabel arrivingAirportLbl = new JLabel(ARR_AIRPORT_MESSAGE);
        JLabel arrivingTimeLbl = new JLabel(ARR_TIME_MESSAGE);

        eventTimeTF = new JFormattedTextField(DATE_TIME_FORMATTER);
        eventTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        eventTimeTF.setFocusLostBehavior(1);

        priorityBox = new JComboBox(EPriority.values());
        departureAirportTF = new JTextField(TEXT_FIELD_COLUMNS);
        arrivingAirportTF = new JTextField(TEXT_FIELD_COLUMNS);

        arrivingTimeTF = new JFormattedTextField(DATE_TIME_FORMATTER);
        arrivingTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        arrivingTimeTF.setFocusLostBehavior(1);

        add(eventTimeLbl);
        add(eventTimeTF);
        add(priorityLbl);
        add(priorityBox);
        add(departureAirportLbl);
        add(departureAirportTF);
        add(arrivingAirportLbl);
        add(arrivingAirportTF);
        add(arrivingTimeLbl);
        add(arrivingTimeTF);
    }

    public Flight getEntityFromForm() {
        return Flight.Builder.create()
                        .setEventTime(LocalDateTime.parse(eventTimeTF.getText(), DATE_TIME_FORMATTER))
                        .setPriority(EPriority.valueOf(priorityBox.getSelectedItem().toString()))
                        .setDepartureAirport(departureAirportTF.getText())
                        .setArrivingAirPort(arrivingAirportTF.getText())
                        .setArrivingTime(LocalDateTime.parse(arrivingTimeTF.getText(), DATE_TIME_FORMATTER))
                        .build();
    }

    public void clearForm() {
        eventTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
//        priorityBox.(Strings.EMPTY);
        departureAirportTF.setText(Strings.EMPTY);
        arrivingAirportTF.setText(Strings.EMPTY);
        arrivingTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
    }
}
