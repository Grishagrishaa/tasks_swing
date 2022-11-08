package com.desktop.tasks.service.impl;

import com.desktop.tasks.dao.IFlightDao;
import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.service.api.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class IFlightServiceImpl implements ITaskService<Flight> {
    private final IFlightDao dao;

    public IFlightServiceImpl(IFlightDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Flight> findAll() {
        return dao.findAll().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void remove(Flight flight) {
        dao.delete(flight);
    }

    @Override
    public void save(@Valid Flight flight) {
        dao.save(flight);
    }
}
