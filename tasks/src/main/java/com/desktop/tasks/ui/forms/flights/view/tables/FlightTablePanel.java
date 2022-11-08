package com.desktop.tasks.ui.forms.flights.view.tables;

import com.desktop.tasks.ui.forms.flights.model.FlightTableModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component

public class FlightTablePanel extends JPanel {

    private final FlightTableModel tableModel;

    private JTable table;

    FlightTablePanel(FlightTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(table);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public FlightTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}
