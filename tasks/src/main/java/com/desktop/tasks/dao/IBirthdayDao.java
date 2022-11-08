package com.desktop.tasks.dao;

import com.desktop.tasks.dao.entity.tasks.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBirthdayDao extends JpaRepository<Birthday, Long> {
}
