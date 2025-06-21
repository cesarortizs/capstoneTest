package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks()
    {
        List<Task> tasks = taskRepository.findAll();

        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id)
    {
        Task existingTask = taskRepository.findById(id).get();

        return existingTask;
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task newTask)
    {
        taskRepository.save(newTask);
    }

    @PutMapping("/tasks/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task updatedTask)
    {
        Task existingTask = taskRepository.findById(id).get();

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDate(updatedTask.getDate());

        taskRepository.save(existingTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id)
    {
        taskRepository.deleteById(id);
    }
}
