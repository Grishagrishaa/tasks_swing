package com.desktop.tasks.dao;

import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessMeetDao extends JpaRepository<BusinessMeet, Long> {
}
