package com.kamilkuk.task_manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String taskContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfCompletion;

//    public Task(String taskContent, String dateOfCompletion) {
//        this.taskContent = taskContent;
//        this.dateOfCompletion = LocalDate.parse(dateOfCompletion, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
}
