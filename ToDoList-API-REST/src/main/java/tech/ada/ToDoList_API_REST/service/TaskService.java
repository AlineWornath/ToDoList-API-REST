package tech.ada.ToDoList_API_REST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findByStatus(Task.Status status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteById(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            throw new IllegalArgumentException("Tarefa não encontrada com o ID: " + id);
        }

        taskRepository.deleteById(id);
    }

    public Task updateStatus(Long id, Task.Status status) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new IllegalArgumentException("Tarefa não encontrada com o ID: " + id);
        }

        Task task = optionalTask.get();

        task.setStatus(status);

        return taskRepository.save(task);
    }
    public void deleteAll() {
        taskRepository.deleteAll();
    }
}