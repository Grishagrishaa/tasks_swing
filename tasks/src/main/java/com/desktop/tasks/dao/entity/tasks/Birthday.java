package com.desktop.tasks.dao.entity.tasks;

import com.desktop.tasks.service.enums.EPriority;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "birthday", schema = "tasks")
public class Birthday extends BaseTask {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Latin letters only")
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Latin letters only")
    private String lastname;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Latin letters only")
    private String patronymic;

    public Birthday(Long id,
                    LocalDateTime createDate,
                    LocalDateTime eventTime, EPriority priority,
                    String name, String lastname, String patronymic) {
        super(id, createDate, eventTime, priority);
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    public Birthday(Builder builder) {
        super(builder.eventTime, builder.priority);
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.patronymic = builder.patronymic;
    }

    public Birthday() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public static class Builder{
        private LocalDateTime eventTime;
        private EPriority priority;

        private String name;
        private String lastname;
        private String patronymic;

        private Builder(){
        }

        public Builder setEventTime(LocalDateTime eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder setPriority(EPriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Birthday build(){
            return new Birthday(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return Objects.equals(name, birthday.name) && Objects.equals(lastname, birthday.lastname) && Objects.equals(patronymic, birthday.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, patronymic);
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
