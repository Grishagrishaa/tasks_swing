package com.desktop.tasks.service.impl;

import com.desktop.tasks.dao.api.ITaskDao;
import com.desktop.tasks.dao.entity.tasks.Birthday;
import com.desktop.tasks.service.api.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class IBirthdayServiceImpl implements ITaskService<Birthday> {
    private final ITaskDao<Birthday> dao;

    public IBirthdayServiceImpl(ITaskDao<Birthday> dao) {
        this.dao = dao;
    }

    @Override
    public List<Birthday> findAll() {
        return dao.findAll().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void remove(Birthday birthday) {
        dao.delete(birthday);
    }

    @Override
    public void save(@Valid Birthday birthday) {
        dao.save(birthday);
    }
}
