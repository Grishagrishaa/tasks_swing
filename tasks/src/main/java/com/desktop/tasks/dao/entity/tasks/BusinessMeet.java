package com.desktop.tasks.dao.entity.tasks;

import com.desktop.tasks.dao.entity.Participant;
import com.desktop.tasks.service.enums.EPriority;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class BusinessMeet extends BaseTask{
    @NotNull
    @NotEmpty
    private String place;
    private List<Participant> participants;

    public BusinessMeet(LocalDateTime eventTime, EPriority priority,
                        String place, List<Participant> participants) {
        super(eventTime, priority);
        this.place = place;
        this.participants = participants;
    }

    public BusinessMeet(Builder builder) {
        super(builder.eventTime, builder.priority);
        this.place = builder.place;
        this.participants = builder.participants;
    }

    public BusinessMeet() {
    }

    public String getPlace() {
        return place;
    }

    public List<Participant> getParticipants() {
        return participants;
    }


    public static class Builder{
        private LocalDateTime eventTime;
        private EPriority priority;
        private String place;
        private List<Participant> participants;

        private Builder() {
        }

        public Builder setEventTime(LocalDateTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder setPriority(EPriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder setPlace(String place) {
            this.place = place;
            return this;
        }

        public Builder setParticipants(List<Participant> participants) {
            this.participants = participants;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public BusinessMeet build(){
            return new BusinessMeet(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessMeet that = (BusinessMeet) o;
        return Objects.equals(place, that.place) && Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, participants);
    }

    @Override
    public String toString() {
        return "BusinessMeet{" +
                "place='" + place + '\'' +
                ", participants=" + participants +
                '}';
    }
}
