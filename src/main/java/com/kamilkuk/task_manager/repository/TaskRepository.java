package com.kamilkuk.task_manager.repository;

import com.kamilkuk.task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
