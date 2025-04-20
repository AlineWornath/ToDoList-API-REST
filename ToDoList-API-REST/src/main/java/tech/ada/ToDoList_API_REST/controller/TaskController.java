package tech.ada.ToDoList_API_REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task.Status status) {
        return taskService.updateStatus(id, status);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllTasks() {
        taskService.deleteAll();
        return ResponseEntity.ok("Todas as tarefas foram deletadas com sucesso.");
    }
}
