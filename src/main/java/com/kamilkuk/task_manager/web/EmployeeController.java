package com.kamilkuk.task_manager.web;

import com.kamilkuk.task_manager.model.Employee;
import com.kamilkuk.task_manager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.get(id));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }


    @PostMapping("/teams/{teamId}/employee")
    public ResponseEntity<Employee> saveForTeam(@PathVariable Long teamId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveForTeam(teamId, employee));
    }

    @PatchMapping("/teams/{teamId}/employee/{employeeId}")
    public ResponseEntity<Employee> assignToTeam(@PathVariable Long teamId, @PathVariable Long employeeId, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.assignToTeam(teamId, employeeId, employee));
    }

    @DeleteMapping("/teams/{teamId}/employee/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long teamId, @PathVariable Long employeeId) {
        employeeService.remove(teamId, employeeId);
        return ResponseEntity.ok(true);
    }
}
