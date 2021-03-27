package com.kamilkuk.task_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @NotBlank(message = "Content needed")
    @Length(max=350, message = "Name must not be longer than 350 characters")
    private String teamName;

    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @NotEmpty(message = "Must assign at least one employee")
    private List<Employee> employees = new ArrayList<>();

    public void setEmployee(Employee employee) {
        this.employees.add(employee);
    }

}
