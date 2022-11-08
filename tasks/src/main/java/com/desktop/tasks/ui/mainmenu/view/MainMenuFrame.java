package com.desktop.tasks.ui.mainmenu.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.validation.Valid;
import java.awt.*;

@Component
public class MainMenuFrame extends JFrame {
    private static final int HEIGHT = 40;
    private static final int WIDTH = 90;

    @Value("${app.flightTableTitle}")
    private String flights_title;

    private JButton flightsBtn;
    private JButton birthdaysBtn;
    private JButton meetBtn;


    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH));
        setTitle("Main Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        LookAndFeelUp();

        setLayout(new GridLayout(1, 3, 40, 40));
    }

    private void LookAndFeelUp() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "There was an error while loading windows look an feel:" + e,
                    "Alert",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        flightsBtn = new JButton(flights_title);
        birthdaysBtn = new JButton("Birthdays");
        meetBtn = new JButton("Meetings");
        add(flightsBtn);
        add(birthdaysBtn);
        add(meetBtn);

    }

    public JButton getFlightsBtn() {
        return flightsBtn;
    }

    public JButton getBirthdaysBtn() {
        return birthdaysBtn;
    }

    public JButton getMeetBtn() {
        return meetBtn;
    }
}
