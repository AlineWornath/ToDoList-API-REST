package tech.ada.ToDoList_API_REST.controller;

import tech.ada.ToDoList_API_REST.model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface TaskController {

    Task createTask(String title, String description, String deadline, Task.Status status);

    Task updateTask(Long id, String title, String description, String deadline, Task.Status status);

    Task updateTaskStatus(Long id, Task.Status newStatus);

    List<Task> getAllTasks(Optional<Comparator<Task>> orderBy);

    List<Task> getTasksByStatus(Task.Status status, Optional<Comparator<Task>> orderBy);

    List<Task> getTasksBy(Predicate<Task> predicate, Optional<Comparator<Task>> orderBy);
}
