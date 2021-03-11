package com.kamilkuk.task_manager.service;

import com.kamilkuk.task_manager.model.Employee;
import com.kamilkuk.task_manager.model.Task;
import com.kamilkuk.task_manager.model.Team;
import com.kamilkuk.task_manager.repository.EmployeeRepository;
import com.kamilkuk.task_manager.repository.TaskRepository;
import com.kamilkuk.task_manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee get(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException());
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee saveForTeam(Long teamId, Employee employee){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            team.get().setEmployee(employee);
            return employeeRepository.save(employee);
        } else
            throw new NoSuchElementException();
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee assignToTeam(Long teamId, Long employeeId, Employee employee){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            Employee employeeOld = get(employeeId);
            employeeOld.setNameEmployee(employee.getNameEmployee());
            return employeeRepository.save(employeeOld);
        } else
            throw new NoSuchElementException();
    }

    public void remove(Long teamId, Long employeeId){
        Employee employee = get(employeeId);
        teamRepository.findById(teamId).get().getEmployees().remove(employee);
        employeeRepository.delete(employee);
    }


}
