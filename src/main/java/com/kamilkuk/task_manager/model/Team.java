package com.kamilkuk.task_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    public void setEmployee(Employee employee) {
        this.employees.add(employee);
    }

}
