package com.desktop.tasks.dao.api;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITaskDao <T>{//T -> TASK TYPE
    List<T> findAll();

    void delete(T task);

    void save(T task);
}
