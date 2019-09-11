package com.marishaoza.taskmaster.Controllers;


import com.marishaoza.taskmaster.Models.Task;
import com.marishaoza.taskmaster.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return (List) taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task addNewUser (@RequestBody Task task) {
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus("Available");
        taskRepository.save(newTask);
        return newTask;
    }

    @PutMapping("/tasks/{id}/state")
    public Task updateTaskStatus (@PathVariable String id) {
        Task taskToUpdate = taskRepository.findById(id).get();
        if (taskToUpdate.getStatus().equals("Available")) {
            taskToUpdate.setStatus("Assigned");
        } else if (taskToUpdate.getStatus().equals("Assigned")) {
            taskToUpdate.setStatus("Accepted");
        } else if (taskToUpdate.getStatus().equals("Accepted")) {
            taskToUpdate.setStatus("Finished");
        }
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }
}
