package br.com.todolist.top1.repository;

import br.com.todolist.top1.exception.TaskIdNotFoundException;
import br.com.todolist.top1.exception.TaskNullException;
import br.com.todolist.top1.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class TaskRepository {
    private Map<Integer, Task> data = new HashMap<>();
    private int id = 1;

    public Task save(Task task) {
        task.setId(id);
        data.put(id, task);
        id++;
        return task;
    }

    public List<Task> getAll() {
        if (data.isEmpty()) {
            throw new TaskNullException("Nenhum sinal de vida");
        }
        return new ArrayList<>(data.values());
    }

    public Task findById(int id) {
        if (!data.containsKey(id)) {
            try {
                throw new TaskIdNotFoundException("ID não existe");
            } catch (TaskIdNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return data.get(id);
    }

    public Task updadeTask(int id, Task updatedTask) {
        if (!data.containsKey(id)) {
            try {
                throw new TaskIdNotFoundException("ID não existe");
            } catch (TaskIdNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        updatedTask.setId(id);
        data.put(id, updatedTask);
        return updatedTask;
    }

    public Boolean delete(int id) {
        return data.remove(id) != null;
    }
}
