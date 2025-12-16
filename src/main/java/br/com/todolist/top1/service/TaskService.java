package br.com.todolist.top1.service;

import br.com.todolist.top1.DTO.TaskDTO;
import br.com.todolist.top1.model.Task;
import br.com.todolist.top1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task createTask (TaskDTO title) {
        Task task = new Task();
        task.setTitle(title.title());
        task.setDone(false);

        return repository.save(task);
    };

    public List<Task> getAll() {
        return repository.getAll();
    }

    public Task findById(int id) {
        return repository.findById(id);
    }

    public Task updateTask(int id, Task updatedTask) {
        return repository.updadeTask(id, updatedTask);
    }

    public boolean removeTask (int id) {
        return repository.delete(id);
    }
}
