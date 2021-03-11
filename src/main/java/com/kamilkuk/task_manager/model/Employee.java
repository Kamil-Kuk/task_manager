package com.kamilkuk.task_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEmployee;

//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<Task> personalTasks = new HashSet<>();

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Task> personalTasks = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;

//
//    public void setPersonalTasks(List<Task> personalTasks) {
//        this.personalTasks = personalTasks;
//        personalTasks.forEach(task -> task.setEmployee(this));
//    }
//
//    public Employee(Long id, String nameEmployee) {
//        this.id = id;
//        this.nameEmployee = nameEmployee;
//    }
}
