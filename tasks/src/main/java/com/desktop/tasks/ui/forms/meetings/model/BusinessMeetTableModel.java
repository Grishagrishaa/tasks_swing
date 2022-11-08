package com.desktop.tasks.ui.forms.meetings.model;

import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import com.desktop.tasks.ui.forms.shared.model.DefaultTableModel;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class BusinessMeetTableModel extends DefaultTableModel<BusinessMeet> {
    @Value("${app.eventTime}")
    private String EVENT_TIME_MESSAGE;
    @Value("${app.priority}")
    private String PRIORITY_MESSAGE;
    @Value("${app.place}")
    private String PLACE_MESSAGE;
    @Value("${app.participants}")
    private String PARTICIPANTS_MESSAGE;

    private static final int EVENT_TIME_INDEX = 0;
    private static final int PRIORITY_INDEX = 1;
    private static final int PLACE_INDEX = 2;
    private static final int PARTICIPANTS_INDEX = 3;

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                EVENT_TIME_MESSAGE,
                PRIORITY_MESSAGE,
                PLACE_MESSAGE,
                PARTICIPANTS_MESSAGE,
                };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BusinessMeet meet = entities.get(rowIndex);

        switch (columnIndex) {
            case EVENT_TIME_INDEX:
                return meet.getEventTime();
            case PRIORITY_INDEX:
                return meet.getPriority();
            case PLACE_INDEX:
                return meet.getPlace();
            case PARTICIPANTS_INDEX:
                return meet.getParticipants();
            default:
                return Strings.EMPTY;
        }
    }

}
