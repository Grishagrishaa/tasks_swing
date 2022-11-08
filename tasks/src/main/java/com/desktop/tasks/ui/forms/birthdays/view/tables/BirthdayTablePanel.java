package com.desktop.tasks.ui.forms.birthdays.view.tables;

import com.desktop.tasks.ui.forms.birthdays.model.BirthdayTableModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component

public class BirthdayTablePanel extends JPanel {

    private final BirthdayTableModel tableModel;

    private JTable table;

    BirthdayTablePanel(BirthdayTableModel tableModel) {
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

    public BirthdayTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}
