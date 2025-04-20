package tech.ada.ToDoList_API_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.ToDoList_API_REST.model.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Task.Status status);



}
