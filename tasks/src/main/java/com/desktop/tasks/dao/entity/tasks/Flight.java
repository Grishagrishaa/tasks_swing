package com.desktop.tasks.dao.entity.tasks;

import com.desktop.tasks.service.enums.EPriority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight extends BaseTask{
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    private String departureAirport;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    private String arrivingAirPort;
    @NotNull
    private LocalDateTime arrivingTime;

    public Flight(Long id,
                  LocalDateTime createDate,
                  LocalDateTime eventTime, EPriority priority,
                  String departureAirport, String arrivingAirPort,
                  LocalDateTime arrivingTime) {
        super(id, createDate, eventTime, priority);
        this.departureAirport = departureAirport;
        this.arrivingAirPort = arrivingAirPort;
        this.arrivingTime = arrivingTime;
    }

    public Flight(Builder builder) {
        super(builder.eventTime, builder.priority);
        this.departureAirport = builder.departureAirport;
        this.arrivingAirPort = builder.arrivingAirPort;
        this.arrivingTime = builder.arrivingTime;
    }

    public Flight() {
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivingAirPort() {
        return arrivingAirPort;
    }

    public LocalDateTime getArrivingTime() {
        return arrivingTime;
    }

    public static class Builder{
        private LocalDateTime eventTime;
        private EPriority priority;

        private String departureAirport;
        private String arrivingAirPort;
        private LocalDateTime arrivingTime;

        private Builder() {
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setArrivingAirPort(String arrivingAirPort) {
            this.arrivingAirPort = arrivingAirPort;
            return this;
        }

        public Builder setArrivingTime(LocalDateTime arrivingTime) {
            this.arrivingTime = arrivingTime;
            return this;
        }

        public Builder setEventTime(LocalDateTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder setPriority(EPriority priority) {
            this.priority = priority;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Flight build(){
            return new Flight(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivingAirPort, flight.arrivingAirPort) && Objects.equals(arrivingTime, flight.arrivingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivingAirPort, arrivingTime);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "DepartureAirport='" + departureAirport + '\'' +
                ", ArrivingAirPort='" + arrivingAirPort + '\'' +
                ", arrivingTime=" + arrivingTime +
                '}';
    }
}
