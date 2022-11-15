package com.desktop.tasks.dao.entity.tasks;

import com.desktop.tasks.service.enums.EPriority;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public class BaseTask implements Comparable<BaseTask>{
    private Long id;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime eventTime;
    @NotNull
    private EPriority priority;

    public BaseTask(Long id, LocalDateTime createDate, LocalDateTime eventTime, EPriority priority) {
        this.id = id;
        this.createDate = createDate;
        this.eventTime = eventTime;
        this.priority = priority;
    }

    public BaseTask(LocalDateTime eventTime, EPriority priority) {
        this.eventTime = eventTime;
        this.priority = priority;
    }

    public BaseTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public EPriority getPriority() {
        return priority;
    }

    public void setPriority(EPriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTask baseTask = (BaseTask) o;
        return Objects.equals(id, baseTask.id) && Objects.equals(createDate, baseTask.createDate) && Objects.equals(eventTime, baseTask.eventTime) && priority == baseTask.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, eventTime, priority);
    }

    @Override
    public String toString() {
        return "BaseTask{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", eventTime=" + eventTime +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(BaseTask o) {
        int compare = eventTime.compareTo(o.getEventTime());
        if(compare == 0){
            return priority.compareTo(o.getPriority());
        }
        return compare;
    }
}
