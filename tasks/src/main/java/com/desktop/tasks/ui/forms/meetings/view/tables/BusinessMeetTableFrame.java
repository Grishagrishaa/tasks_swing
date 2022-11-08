package com.desktop.tasks.ui.forms.meetings.view.tables;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class BusinessMeetTableFrame extends JFrame {
    @Value("${app.meetingsTableTitle}")
    private String BUSINESS_MEET_TABLE_TITLE;

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 300;

    private final BusinessMeetTablePanel tablePanel;
    private final BusinessMeetTableBtnPanel tableBtnPanel;

    public BusinessMeetTableFrame(BusinessMeetTablePanel tablePanel, BusinessMeetTableBtnPanel tableBtnPanel) throws HeadlessException {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
    }

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(BUSINESS_MEET_TABLE_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public BusinessMeetTablePanel getTablePanel() {
        return tablePanel;
    }

    public BusinessMeetTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }
}
