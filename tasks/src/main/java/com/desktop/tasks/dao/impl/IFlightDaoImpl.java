package com.desktop.tasks.dao.impl;

import com.desktop.tasks.dao.api.ITaskDao;
import com.desktop.tasks.dao.entity.tasks.Flight;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class IFlightDaoImpl implements ITaskDao<Flight> {
    private final List<Flight> flightList;

    public IFlightDaoImpl() {
        this.flightList = new LinkedList<>();
    }

    @Override
    public List<Flight> findAll() {
        return flightList;
    }

    @Override
    public void delete(Flight task) {
        flightList.remove(task);
    }

    @Override
    public void save(Flight task) {
        flightList.add(task);
    }
}
