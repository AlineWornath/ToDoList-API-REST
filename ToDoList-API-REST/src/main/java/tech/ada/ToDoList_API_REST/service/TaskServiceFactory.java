package tech.ada.ToDoList_API_REST.service;

import tech.ada.ToDoList_API_REST.config.ConfigConstants;
import tech.ada.ToDoList_API_REST.repository.TaskRepository;
import tech.ada.ToDoList_API_REST.repository.TaskRepositoryHashMapImpl;
import tech.ada.ToDoList_API_REST.service.notification.TaskNotifier;
import tech.ada.ToDoList_API_REST.service.validation.DeadlineValidation;
import tech.ada.ToDoList_API_REST.service.validation.StatusValidation;
import tech.ada.ToDoList_API_REST.service.validation.TaskValidator;
import tech.ada.ToDoList_API_REST.service.validation.TitleValidation;

import java.util.List;

public class TaskServiceFactory {

    public static TaskService createTaskService() {
        TaskRepository repository = TaskRepositoryHashMapImpl.getInstance();

        TaskValidator validator = new TaskValidator(List.of(
                new TitleValidation(),
                new DeadlineValidation(),
                new StatusValidation()
        ));

        return TaskServiceImpl.create(repository, validator, new TaskNotifier(repository, ConfigConstants.DEFAULT_THRESHOLD_DAYS, ConfigConstants.NOTIFICATION_COOLDOWN_MINUTES));
    }
}
