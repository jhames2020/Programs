package ProgramExercises.Task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ProgramExercises.Task.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listTasks", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/showTaskForm")
    public String showTaskForm(Model model){
        Task task = new Task();
        String AttributeName;
        model.addAttribute(AttributeName:"task", task);
        return "new_task";
    }

    @PostMapping("/addTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.saveTasks(task);
        return "new_task";
    }
}