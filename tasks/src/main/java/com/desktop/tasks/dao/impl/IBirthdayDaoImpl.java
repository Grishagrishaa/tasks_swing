package com.desktop.tasks.dao.impl;

import com.desktop.tasks.dao.api.ITaskDao;
import com.desktop.tasks.dao.entity.tasks.Birthday;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class IBirthdayDaoImpl implements ITaskDao<Birthday> {
    private final List<Birthday> birthdaysList;

    public IBirthdayDaoImpl() {
        this.birthdaysList = new LinkedList<>();
    }

    @Override
    public List<Birthday> findAll() {
        return birthdaysList;
    }

    @Override
    public void delete(Birthday task) {
        birthdaysList.remove(task);
    }

    @Override
    public void save(Birthday task) {
        birthdaysList.add(task);
    }
}
