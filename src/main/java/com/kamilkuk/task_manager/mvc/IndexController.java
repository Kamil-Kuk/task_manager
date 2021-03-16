package com.kamilkuk.task_manager.mvc;

import com.kamilkuk.task_manager.model.Task;
import com.kamilkuk.task_manager.model.Team;
import com.kamilkuk.task_manager.service.EmployeeService;
import com.kamilkuk.task_manager.service.TaskService;
import com.kamilkuk.task_manager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final TeamService teamService;

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/show-tasks")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "show-tasks";
    }

    @GetMapping("/show-employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "show-employees";
    }

    @GetMapping("/show-teams")
    public String showTeams(Model model) {
        model.addAttribute("teams", teamService.getAll());
        return "show-teams";
    }

    @GetMapping("/add-task")
    public String showAddTaskForm(Task task, Model model) {
        model.addAttribute("teams", teamService.getAll());
        return "add-task";
    }


    @PostMapping("/add-task")
    public String addTask(@Valid Task task,
                          @ModelAttribute("team") Long team,
                          Errors error) {
        if (error.hasErrors()) {
            return "add-task";
        }
        taskService.saveForTeam(team, task);
        return "redirect:/show-tasks";
    }
}