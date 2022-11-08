package com.desktop.tasks.ui.forms.meetings.view.forms;

import com.desktop.tasks.dao.entity.Participant;
import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import com.desktop.tasks.service.enums.EPriority;
import com.desktop.tasks.ui.forms.meetings.utils.RegexFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class BusinessMeetFormPanel extends JPanel  {
    @Value("${app.eventTime}")
    private String EVENT_TIME_MESSAGE;
    @Value("${app.priority}")
    private String PRIORITY_MESSAGE;
    @Value("${app.place}")
    private String PLACE_MESSAGE;
    @Value("${app.participants}")
    private String PARTICIPANTS_MESSAGE;

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;

    private static final int LAYOUT_ROWS = 15;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;

    private JFormattedTextField eventTimeTF;
    private JComboBox priorityBox;
    private JFormattedTextField placeTF;
    private JFormattedTextField participantTF;
    private JFormattedTextField participant1TF;
    private JFormattedTextField participant2TF;
    private JFormattedTextField participant3TF;


    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setBorder(BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH));
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel eventTimeLbl = new JLabel(EVENT_TIME_MESSAGE);
        JLabel priorityLbl = new JLabel(PRIORITY_MESSAGE);
        JLabel placeLbl = new JLabel(PLACE_MESSAGE);

        eventTimeTF = new JFormattedTextField(DATE_TIME_FORMATTER);
        eventTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        eventTimeTF.setFocusLostBehavior(1);
        priorityBox = new JComboBox(EPriority.values());

        RegexFormatter regexFormatter = new RegexFormatter("^[a-zA-Z]*$");

        placeTF = new JFormattedTextField(regexFormatter);
        placeTF.setFocusLostBehavior(1);

        participantTF = new JFormattedTextField();
        participant1TF = new JFormattedTextField();
        participant2TF = new JFormattedTextField();
        participant3TF = new JFormattedTextField();




        JButton addButton = new JButton("Add participant!");
        addButton.addActionListener(a -> {
            add(new JLabel(PARTICIPANTS_MESSAGE));
            JFormattedTextField pcpnt = new JFormattedTextField();
            pcpnt.setName("Participant");
            add(pcpnt);
            updateUI();
        });


        placeTF.setName("Non-participant");
        eventTimeTF.setName("Non-participant");
        participant2TF.setName("Participant");
        participant1TF.setName("Participant");
        participantTF.setName("Participant");
        participant3TF.setName("Participant");

        add(new JLabel("More Participants"));
        add(addButton);
        add(eventTimeLbl);
        add(eventTimeTF);
        add(priorityLbl);
        add(priorityBox);
        add(placeLbl);
        add(placeTF);
        add(new JLabel(PARTICIPANTS_MESSAGE));
        add(participantTF);
        add(new JLabel(PARTICIPANTS_MESSAGE));
        add(participant1TF);
        add(new JLabel(PARTICIPANTS_MESSAGE));
        add(participant2TF);
        add(new JLabel(PARTICIPANTS_MESSAGE));
        add(participant3TF);

    }

    public BusinessMeet getEntityFromForm() {
        return BusinessMeet.Builder.create()
                        .setEventTime(LocalDateTime.parse(eventTimeTF.getText(), DATE_TIME_FORMATTER))
                        .setPriority(EPriority.valueOf(priorityBox.getSelectedItem().toString()))
                        .setPlace(placeTF.getText())
                        .setParticipants(Arrays.stream(getComponents())
                                .filter(c -> c instanceof JFormattedTextField)
                                .filter(c -> c.getName().equals("Participant"))
                                .map(c -> (JFormattedTextField) c)
                                .map(tf -> new Participant(tf.getText()))
                                .collect(Collectors.toList()))
                        .build();
    }

    public void clearForm() {
        removeAll();
        initComponents();
    }
}
