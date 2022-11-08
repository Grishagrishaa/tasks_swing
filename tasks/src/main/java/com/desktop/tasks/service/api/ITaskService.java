package com.desktop.tasks.service.api;


import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Transactional(readOnly = true)
public interface ITaskService<T> {

    List<T> findAll();

    @Transactional
    void remove(T task);

    @Transactional
    void save(@Valid T task);
}
