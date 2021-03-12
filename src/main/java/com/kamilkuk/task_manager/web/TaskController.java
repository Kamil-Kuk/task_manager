package com.kamilkuk.task_manager.web;

import com.kamilkuk.task_manager.model.Task;
import com.kamilkuk.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {


    private final TaskService taskService;


    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.get(id));
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }


    @PostMapping("/teams/{teamId}/task")
    public ResponseEntity<Task> saveForTeam(@PathVariable Long teamId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveForTeam(teamId, task));
    }

    @PatchMapping("/tasks")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.update(task));
    }


    @PatchMapping("/teams/{teamId}/task/{taskId}")
    public ResponseEntity<Task> assignToTeam(@PathVariable Long teamId, @PathVariable Long taskId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.assignToTeam(teamId, taskId, task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        taskService.remove(id);
        return ResponseEntity.ok(true);
    }
}
