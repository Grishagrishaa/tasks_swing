package com.desktop.tasks.dao;

import com.desktop.tasks.dao.entity.tasks.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightDao extends JpaRepository<Flight, Long> {
}
