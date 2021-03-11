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
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task get(Long id){
        return taskRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException());
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

//    public Task saveForEmployee(Long employeeId, Task task){
//        return employeeRepository.findById(employeeId)
//                .map(employee -> {task.setEmployee(employee);
//                        return taskRepository.save(task);}
//        ).orElseThrow(()->new NoSuchElementException());
//    }

    public Task saveForTeam(Long teamId, Task task){
        return teamRepository.findById(teamId)
                .map(team -> {task.setTeam(team);
                    return taskRepository.save(task);}
                ).orElseThrow(()->new NoSuchElementException());
    }

    public Task update(Task task){
        return taskRepository.save(task);
    }

//    public Task assignToEmployee(Long employeeId, Task task){
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//        if(employee.isPresent()){
//            task.setEmployee(employee.get());
//            return taskRepository.save(task);
//        } else
//            throw new NoSuchElementException();
//    }

    public Task assignToTeam(Long teamId, Long taskId, Task task){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isPresent()){
            Task taskOld = get(taskId);
            taskOld.setTaskContent(task.getTaskContent());
            taskOld.setDateOfCompletion(task.getDateOfCompletion());
            task.setTeam(team.get());
            return taskRepository.save(taskOld);
        } else
            throw new NoSuchElementException();
    }

    public void remove(Long id){
        taskRepository.delete(get(id));
    }



}
