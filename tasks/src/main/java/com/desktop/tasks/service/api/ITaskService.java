package com.desktop.tasks.service.api;



import javax.validation.Valid;
import java.util.List;

public interface ITaskService<T> {

    List<T> findAll();

    void remove(T task);

    void save(@Valid T task);
}
