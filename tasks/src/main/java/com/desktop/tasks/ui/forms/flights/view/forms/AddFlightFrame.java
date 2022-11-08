package com.desktop.tasks.ui.forms.flights.view.forms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AddFlightFrame extends JDialog {
    @Value("${app.addFlightWindow}")
    private String ADD_FLIGHT_WINDOW_TITLE;

    private final FlightFormPanel formPanel;
    private final FlightFormBtnPanel formBtnPanel;

    public AddFlightFrame(FlightFormPanel formPanel, FlightFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
    }

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ADD_FLIGHT_WINDOW_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
//        setSize(600, 200);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public FlightFormPanel getFormPanel() {
        return formPanel;
    }

    public FlightFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}
