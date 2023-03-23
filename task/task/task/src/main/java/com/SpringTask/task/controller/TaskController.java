package com.SpringTask.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringTask.task.model.Task;
import com.SpringTask.task.service.TaskService;

@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("task", taskService.getAllTasks());
        return "index";
    }
    @GetMapping("/showNewTaskForm")
	public String showNewTaskForm(Model model) {
		// create model attribute to bind form data
		Task task = new Task();
		model.addAttribute("task", task);
		return "newtask";
	}
    @PostMapping("/saveTask")
	public String saveTasks(@ModelAttribute("task") Task task) {
		taskService.saveTasks(task);
		return "redirect:/"; 
	}
    @GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		// get task from the service
		Task task = taskService.getTaskById(id);

		// set task as a model attribute to pre-populate the form
		model.addAttribute("task", task);
		return "updatetask";
	}
    @GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.taskService.deleteTaskById(id);
		return "redirect:/";
	}
}
