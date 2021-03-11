package com.kamilkuk.task_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private String taskContent;

    private LocalDate dateOfCompletion;
}
