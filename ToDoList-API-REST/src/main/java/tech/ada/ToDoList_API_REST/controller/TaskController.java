package tech.ada.ToDoList_API_REST.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Criar uma nova tarefa", description = "Cria uma nova tarefa com título, descrição, deadline e status inicial")
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping
    @Operation(summary = "Listar todas as tarefas", description = "Retorna uma lista com todas as tarefas cadastradas")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{status}")
    @Operation(summary = "Listar tarefas por status", description = "Retorna uma lista de tarefas filtradas por status")
    public List<Task> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.findByStatus(status);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar status da tarefa", description = "Atualiza o status de uma tarefa existente pelo ID")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task.Status status) {
        return taskService.updateStatus(id, status);
    }

    @DeleteMapping
    @Operation(summary = "Deletar todas as tarefas", description = "Remove todas as tarefas cadastradas no sistema")
    public ResponseEntity<String> deleteAllTasks() {
        taskService.deleteAll();
        return ResponseEntity.ok("Todas as tarefas foram deletadas com sucesso.");
    }
}
