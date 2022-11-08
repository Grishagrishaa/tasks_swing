package com.desktop.tasks.ui.forms.flights.view.tables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class FlightTableFrame extends JFrame {
    @Value("${app.flightTableTitle}")
    private String FLIGHT_TABLE_TITLE;

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 300;

    private final FlightTablePanel tablePanel;
    private final FlightTableBtnPanel tableBtnPanel;

    public FlightTableFrame(FlightTablePanel tablePanel, FlightTableBtnPanel tableBtnPanel) throws HeadlessException {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
    }

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(FLIGHT_TABLE_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public FlightTablePanel getTablePanel() {
        return tablePanel;
    }

    public FlightTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }
}
