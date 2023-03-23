package ProgramExercises.Task.service;

import java.util.List;

import org.springframework.scheduling.config.Task;


public interface TaskService {
    List<Task> getAllTasks();

    void saveTasks(Task task);
}
