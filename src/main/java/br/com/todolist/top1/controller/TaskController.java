package br.com.todolist.top1.controller;

import br.com.todolist.top1.DTO.TaskDTO;
import br.com.todolist.top1.model.Task;
import br.com.todolist.top1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/home")
    public String home() {
        return "Hello Spring boot";
    }

    @GetMapping
    public List<Task> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Task create(@RequestBody TaskDTO task ) {
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id, @RequestBody Task updatedTask) {
        return service.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return service.removeTask(id);
    }
}
