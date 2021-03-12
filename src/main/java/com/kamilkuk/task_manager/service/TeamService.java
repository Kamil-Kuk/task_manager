package com.kamilkuk.task_manager.service;

import com.kamilkuk.task_manager.model.Team;
import com.kamilkuk.task_manager.repository.EmployeeRepository;
import com.kamilkuk.task_manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team get(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Team team) {
        return teamRepository.save(team);
    }

    public void remove(Long id) {
        teamRepository.delete(get(id));
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}
