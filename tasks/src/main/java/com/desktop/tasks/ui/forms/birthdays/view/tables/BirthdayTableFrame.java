package com.desktop.tasks.ui.forms.birthdays.view.tables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class BirthdayTableFrame extends JFrame {
    @Value("${app.birthdayTableTitle}")
    private String BIRTHDAY_TABLE_TITLE;

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 300;

    private final BirthdayTablePanel tablePanel;
    private final BirthdayTableBtnPanel tableBtnPanel;

    public BirthdayTableFrame(BirthdayTablePanel tablePanel, BirthdayTableBtnPanel tableBtnPanel) throws HeadlessException {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
    }

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(BIRTHDAY_TABLE_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public BirthdayTablePanel getTablePanel() {
        return tablePanel;
    }

    public BirthdayTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }
}
