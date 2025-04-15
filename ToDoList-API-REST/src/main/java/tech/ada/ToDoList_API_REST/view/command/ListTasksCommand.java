package tech.ada.ToDoList_API_REST.view.command;

import tech.ada.ToDoList_API_REST.controller.TaskController;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.service.TaskComparators;
import tech.ada.ToDoList_API_REST.view.View;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ListTasksCommand implements Command {

    private final View view;
    private final TaskController taskController;

    public ListTasksCommand(View view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        Optional<Comparator<Task>> orderBy = getSortingMethod();
        List<Task> tasks = taskController.getAllTasks(orderBy);

        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString()));
        }
    }

    private Optional<Comparator<Task>> getSortingMethod() {
        view.showMessage("Escolha o critério de ordenação:");
        view.showMessage("1 - Por Data Limite");
        view.showMessage("2 - Por Título");
        view.showMessage("3 - Por Status");
        view.showMessage("4 - Sem ordenação");

        int option = view.getIntInput("Digite o número da opção");

        if (option == 4) {
            return Optional.empty();
        }

        view.showMessage("Deseja ordem reversa? (S/N)");
        boolean reversed = view.getInput("").trim().equalsIgnoreCase("S");

        String criteria = switch (option) {
            case 2 -> "title";
            case 3 -> "status";
            default -> "deadline";
        };

        return Optional.of(TaskComparators.getComparator(criteria, reversed));
    }
}
