package tech.ada.ToDoList_API_REST.service;

import tech.ada.ToDoList_API_REST.dto.TaskUpdateRequest;
import tech.ada.ToDoList_API_REST.model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface TaskService {

    Task save(Task task);

    List<Task> findAll(Optional<Comparator<Task>> orderBy);

    List<Task> findByStatus(Task.Status status, Optional<Comparator<Task>> orderBy);

    List<Task> findBy(Predicate<Task> predicate, Optional<Comparator<Task>> orderBy);

    Optional<Task> findById(Long id);

    default Task getById(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
    }


    boolean deleteById(Long id);

    void clearAll();

    Task updateTask(TaskUpdateRequest updateRequest);

    Task updateStatus(Long id, Task.Status newStatus);

    void stopNotifier();

    void startNotifier();
}
