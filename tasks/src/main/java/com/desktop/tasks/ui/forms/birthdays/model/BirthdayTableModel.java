package com.desktop.tasks.ui.forms.birthdays.model;

import com.desktop.tasks.dao.entity.tasks.Birthday;
import com.desktop.tasks.ui.forms.shared.model.DefaultTableModel;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class BirthdayTableModel extends DefaultTableModel<Birthday> {
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

    private static final int EVENT_TIME_INDEX = 0;
    private static final int PRIORITY_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int LASTNAME_INDEX = 3;
    private static final int PATRONYMIC_INDEX = 4;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                EVENT_TIME_MESSAGE,
                PRIORITY_MESSAGE,
                NAME_MESSAGE,
                LASTNAME_MESSAGE,
                PATRONYMIC_MESSAGE};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Birthday birthday = entities.get(rowIndex);

        switch (columnIndex) {
            case EVENT_TIME_INDEX:
                return birthday.getEventTime();
            case PRIORITY_INDEX:
                return birthday.getPriority();
            case NAME_INDEX:
                return birthday.getName();
            case LASTNAME_INDEX:
                return birthday.getLastname();
            case PATRONYMIC_INDEX:
                return birthday.getPatronymic();
            default:
                return Strings.EMPTY;
        }
    }

}
