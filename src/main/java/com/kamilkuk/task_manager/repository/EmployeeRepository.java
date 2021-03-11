package com.kamilkuk.task_manager.repository;

import com.kamilkuk.task_manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
