package com.desktop.tasks.ui.forms.meetings.view.forms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AddBusinessMeetFrame extends JDialog {
    @Value("${app.addMeetingWindow}")
    private String ADD_MEETING_WINDOW_TITLE;

    private final BusinessMeetFormPanel formPanel;
    private final BusinessMeetFormBtnPanel formBtnPanel;

    public AddBusinessMeetFrame(BusinessMeetFormPanel formPanel, BusinessMeetFormBtnPanel formBtnPanel) {
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
        setTitle(ADD_MEETING_WINDOW_TITLE);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public BusinessMeetFormPanel getFormPanel() {
        return formPanel;
    }

    public BusinessMeetFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}
