package com.kamilkuk.task_manager.web;

import com.kamilkuk.task_manager.model.Team;
import com.kamilkuk.task_manager.service.EmployeeService;
import com.kamilkuk.task_manager.service.TaskService;
import com.kamilkuk.task_manager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {


    private final TeamService teamService;

    @GetMapping("{id}")
    public ResponseEntity<Team> get(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAll() {
        return ResponseEntity.ok(teamService.getAll());
    }

    @PostMapping
    public ResponseEntity<Team> save(@Valid @RequestBody Team team) {
        return ResponseEntity.ok(teamService.save(team));
    }

    @PatchMapping
    public ResponseEntity<Team> update(@Valid @RequestBody Team team) {
        return ResponseEntity.ok(teamService.update(team));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        teamService.remove(id);
        return ResponseEntity.ok(true);
    }
}
