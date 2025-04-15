package tech.ada.ToDoList_API_REST.repository;

import tech.ada.ToDoList_API_REST.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface TaskRepository {

    Task save(Task task);

    List<Task> findAll();

    List<Task> findByStatus(String status);
    List<Task> findByStatus(Task.Status status);

    List<Task> findBy(Predicate<Task> predicate);

    Optional<Task> findById(Long id);

    boolean deleteById(Long id);

    void deleteAll();
}