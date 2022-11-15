package com.desktop.tasks.service.impl;

import com.desktop.tasks.dao.api.ITaskDao;
import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import com.desktop.tasks.service.api.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class IBusinessMeetServiceImpl implements ITaskService<BusinessMeet> {
    private final ITaskDao<BusinessMeet> dao;

    public IBusinessMeetServiceImpl(ITaskDao<BusinessMeet> dao) {
        this.dao = dao;
    }

    @Override
    public List<BusinessMeet> findAll() {
        return dao.findAll().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void remove(BusinessMeet meet) {
        dao.delete(meet);
    }

    @Override
    public void save(@Valid BusinessMeet meet) {
        dao.save(meet);
    }
}
