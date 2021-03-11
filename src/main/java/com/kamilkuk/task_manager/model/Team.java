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
@Entity(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

//    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Task> teamTasks = new ArrayList<>();

//    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
//    private Set<Employee> employees = new HashSet<>();

//    @OneToMany(cascade = CascadeType.PERSIST)
//    private Set<Task> teamTasks = new HashSet<>();
//
    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

//    public void setTeamTasks(List<Task> teamTasks) {
//        this.teamTasks = teamTasks;
//        teamTasks.forEach(task -> task.setTeam(this));
//    }

    public void setEmployee(Employee employee){
        this.employees.add(employee);
    }

}
