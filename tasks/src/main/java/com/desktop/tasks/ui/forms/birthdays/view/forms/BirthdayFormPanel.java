package com.desktop.tasks.ui.forms.birthdays.view.forms;

import com.desktop.tasks.dao.entity.tasks.Birthday;
import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.service.enums.EPriority;
import com.desktop.tasks.ui.forms.birthdays.utils.RegexFormatter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BirthdayFormPanel extends JPanel  {
    @Value("${app.eventTime}")
    private String EVENT_TIME_MESSAGE;
    @Value("${app.priority}")
    private String PRIORITY_MESSAGE;
    @Value("${app.name}")
    private String NAME_MESSAGE;
    @Value("${app.lastname}")
    private String LASTNAME_MESSAGE;
    @Value("${app.patronymic}")
    private String PATRONYMIC_MESSAGE;

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);



    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JFormattedTextField eventTimeTF;
    private JComboBox priorityBox;
    private JFormattedTextField nameTF;
    private JFormattedTextField lastnameTF;
    private JFormattedTextField patronymicTF;

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(BorderFactory.createEmptyBorder(HEIGHT, WIDTH, HEIGHT, WIDTH));
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel eventTimeLbl = new JLabel(EVENT_TIME_MESSAGE);
        JLabel priorityLbl = new JLabel(PRIORITY_MESSAGE);
        JLabel nameLbl = new JLabel(NAME_MESSAGE);
        JLabel lastnameLbl = new JLabel(LASTNAME_MESSAGE);
        JLabel patronymicLbl = new JLabel(PATRONYMIC_MESSAGE);

        eventTimeTF = new JFormattedTextField(DATE_TIME_FORMATTER);
        eventTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        eventTimeTF.setFocusLostBehavior(1);

        priorityBox = new JComboBox(EPriority.values());

        RegexFormatter regexFormatter = new RegexFormatter("^[a-zA-Z]*$");
        nameTF = new JFormattedTextField(regexFormatter);
        lastnameTF = new JFormattedTextField(regexFormatter);
        patronymicTF = new JFormattedTextField(regexFormatter);

        nameTF.setFocusLostBehavior(1);
        lastnameTF.setFocusLostBehavior(1);
        patronymicTF.setFocusLostBehavior(1);

        add(eventTimeLbl);
        add(eventTimeTF);
        add(priorityLbl);
        add(priorityBox);
        add(nameLbl);
        add(nameTF);
        add(lastnameLbl);
        add(lastnameTF);
        add(patronymicLbl);
        add(patronymicTF);
    }

    public Birthday getEntityFromForm() {
        return Birthday.Builder.create()
                        .setEventTime(LocalDateTime.parse(eventTimeTF.getText(), DATE_TIME_FORMATTER))
                        .setPriority(EPriority.valueOf(priorityBox.getSelectedItem().toString()))
                        .setName(nameTF.getText())
                        .setLastname(lastnameTF.getText())
                        .setPatronymic(patronymicTF.getText())
                        .build();
    }

    public void clearForm() {
        eventTimeTF.setValue(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        nameTF.setText(Strings.EMPTY);
        lastnameTF.setText(Strings.EMPTY);
        patronymicTF.setText(Strings.EMPTY);
    }
}
