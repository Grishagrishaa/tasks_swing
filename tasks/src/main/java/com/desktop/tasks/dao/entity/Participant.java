package com.desktop.tasks.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Embeddable
public class Participant {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Latin letters only")
    private String fullName;


    public Participant(String fullName) {
        this.fullName = fullName;
    }

    public Participant() {
    }

    public String getFullName() {
        return fullName;
    }

    public Participant setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return fullName + '\n';
    }
}
