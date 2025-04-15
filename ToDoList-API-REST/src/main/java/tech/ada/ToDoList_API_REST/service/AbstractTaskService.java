package tech.ada.ToDoList_API_REST.service;

import tech.ada.ToDoList_API_REST.dto.TaskUpdateRequest;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.repository.TaskRepository;
import tech.ada.ToDoList_API_REST.service.notification.Notifier;
import tech.ada.ToDoList_API_REST.service.validation.TaskValidator;

import java.util.Optional;

public abstract class AbstractTaskService implements TaskService {

    protected final TaskRepository taskRepository;

    protected final TaskValidator taskValidator;
    protected final Notifier notifier;

    public AbstractTaskService(TaskRepository taskRepository, TaskValidator taskValidator, Notifier notifier) {
        if (taskRepository == null) {
            throw new IllegalArgumentException("TaskRepository não pode ser nulo.");
        }
        this.taskRepository = taskRepository;
        if (taskValidator == null) {
            throw new IllegalArgumentException("TaskValidator não pode ser nulo.");
        }
        this.taskValidator = taskValidator;

        if (notifier == null) {
            throw new IllegalArgumentException("Notifier não pode ser nulo.");
        }
        this.notifier = notifier;
    }

    @Override
    public Task save(Task task) {
        validate(task);
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    protected void validate(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Tarefa não pode ser nula.");
        }
        taskValidator.validate(task);
    }


    @Override
    public Task updateStatus(Long id, Task.Status newStatus) {
        Task existingTask = getById(id);
        applyStatusUpdate(existingTask, newStatus);
        return save(existingTask);
    }

    protected void applyStatusUpdate(Task task, Task.Status newStatus) {
        task.setStatus(newStatus);
    }

    @Override
    public Task updateTask(TaskUpdateRequest updateRequest) {
        Task existingTask = getById(updateRequest.getId());

        if (updateRequest.getTitle() != null) {
            existingTask.setTitle(updateRequest.getTitle());
        }
        if (updateRequest.getDescription() != null) {
            existingTask.setDescription(updateRequest.getDescription());
        }
        if (updateRequest.getDeadline() != null) {
            existingTask.setDeadline(updateRequest.getDeadline());
        }
        if (updateRequest.getStatus() != null) {
            applyStatusUpdate(existingTask, updateRequest.getStatus());
        }

        validate(existingTask);
        return save(existingTask);
    }

    @Override
    public boolean deleteById(Long id) {
        return taskRepository.deleteById(id);
    }

    @Override
    public void clearAll() {
        taskRepository.deleteAll();
    }

    @Override
    public void stopNotifier() {
        notifier.stop();
    }

    @Override
    public void startNotifier() {
        notifier.start();
    }
}
