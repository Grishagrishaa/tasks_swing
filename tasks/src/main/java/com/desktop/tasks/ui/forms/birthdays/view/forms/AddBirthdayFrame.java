package com.desktop.tasks.ui.forms.birthdays.view.forms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AddBirthdayFrame extends JDialog {
    @Value("${app.addBirtdayWindow}")
    private String ADD_BIRTHDAY_WINDOW_TITLE;

    private final BirthdayFormPanel formPanel;
    private final BirthdayFormBtnPanel formBtnPanel;

    public AddBirthdayFrame(BirthdayFormPanel formPanel, BirthdayFormBtnPanel formBtnPanel) {
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
        setTitle(ADD_BIRTHDAY_WINDOW_TITLE);
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

    public BirthdayFormPanel getFormPanel() {
        return formPanel;
    }

    public BirthdayFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}
