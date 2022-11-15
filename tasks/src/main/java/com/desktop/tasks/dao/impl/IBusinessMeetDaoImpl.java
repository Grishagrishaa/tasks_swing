package com.desktop.tasks.dao.impl;

import com.desktop.tasks.dao.api.ITaskDao;
import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class IBusinessMeetDaoImpl implements ITaskDao<BusinessMeet> {
    private final List<BusinessMeet> businessMeetList;

    public IBusinessMeetDaoImpl() {
        this.businessMeetList = new LinkedList<>();
    }

    @Override
    public List<BusinessMeet> findAll() {
        return businessMeetList;
    }

    @Override
    public void delete(BusinessMeet task) {
        businessMeetList.remove(task);
    }

    @Override
    public void save(BusinessMeet task) {
        businessMeetList.add(task);
    }
}
