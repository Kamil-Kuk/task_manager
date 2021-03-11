package com.kamilkuk.task_manager.repository;

import com.kamilkuk.task_manager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
