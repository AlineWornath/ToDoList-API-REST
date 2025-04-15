package tech.ada.ToDoList_API_REST.service;

import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.repository.TaskRepository;
import tech.ada.ToDoList_API_REST.service.notification.Notifier;
import tech.ada.ToDoList_API_REST.service.validation.TaskValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TaskServiceImpl extends AbstractTaskService {

    public static final Comparator<Task> DEFAULT_TASK_SORT = Comparator.comparing(Task::getDeadline);
    private static TaskServiceImpl INSTANCE;

    private TaskServiceImpl(TaskRepository taskRepository, TaskValidator taskValidator, Notifier notifier) {
        super(taskRepository, taskValidator, notifier);
    }

    public static TaskServiceImpl create(TaskRepository taskRepository, TaskValidator taskValidator, Notifier notifier) {
        if (INSTANCE == null) {
            synchronized (TaskServiceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskServiceImpl(taskRepository, taskValidator, notifier);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Task> findAll(Optional<Comparator<Task>> orderBy) {
        List<Task> findAll = new ArrayList<>(taskRepository.findAll());
        findAll = findAll.stream().sorted(orderBy.orElse(DEFAULT_TASK_SORT)).toList();
        return findAll;
    }

    @Override
    public List<Task> findByStatus(Task.Status status, Optional<Comparator<Task>> orderBy) {
        List<Task> findByStatus = new ArrayList<>(taskRepository.findByStatus(status));
        findByStatus = findByStatus.stream().sorted(orderBy.orElse(DEFAULT_TASK_SORT)).toList();
        return findByStatus;
    }

    @Override
    public List<Task> findBy(Predicate<Task> predicate, Optional<Comparator<Task>> orderBy) {
        List<Task> findBy = new ArrayList<>(taskRepository.findBy(predicate));
        findBy = findBy.stream().sorted(orderBy.orElse(DEFAULT_TASK_SORT)).toList();
        return findBy;
    }

}
