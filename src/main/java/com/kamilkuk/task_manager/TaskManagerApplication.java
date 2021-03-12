package com.kamilkuk.task_manager;

import com.kamilkuk.task_manager.repository.EmployeeRepository;
import com.kamilkuk.task_manager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
