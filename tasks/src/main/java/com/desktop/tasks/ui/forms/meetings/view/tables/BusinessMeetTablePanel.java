package com.desktop.tasks.ui.forms.meetings.view.tables;

import com.desktop.tasks.ui.forms.meetings.model.BusinessMeetTableModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component

public class BusinessMeetTablePanel extends JPanel {
    @Value("${app.eventTime}")
    private String EVENT_TIME_MESSAGE;
    @Value("${app.priority}")
    private String PRIORITY_MESSAGE;
    @Value("${app.place}")
    private String PLACE_MESSAGE;
    @Value("${app.participants}")
    private String PARTICIPANTS_MESSAGE;

    private final BusinessMeetTableModel tableModel;

    private JTable table;

    BusinessMeetTablePanel(BusinessMeetTableModel tableModel) {
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
        table.getColumn(EVENT_TIME_MESSAGE).sizeWidthToFit();
        table.getColumn(PRIORITY_MESSAGE).sizeWidthToFit();
        table.getColumn(PLACE_MESSAGE).sizeWidthToFit();
        table.getColumn(PARTICIPANTS_MESSAGE).sizeWidthToFit();


        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane paneWithTable = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public BusinessMeetTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}
