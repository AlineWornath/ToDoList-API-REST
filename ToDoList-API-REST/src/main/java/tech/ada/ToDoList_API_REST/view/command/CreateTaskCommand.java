package tech.ada.ToDoList_API_REST.view.command;

import tech.ada.ToDoList_API_REST.controller.TaskController;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.view.View;

import java.util.Optional;

public class CreateTaskCommand implements Command {

    private final View view;
    private final TaskController taskController;

    public CreateTaskCommand(View view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        String title = view.getInput("📌 Informe o título da tarefa");
        String description = view.getInput("📝 Informe a descrição (opcional)");
        String deadline = view.getInput("📅 Informe a data limite (DD/MM/YYYY)");
        String statusStr = view.getInput("🔄 Informe o status (Pendente, Em andamento, Concluído) (ou deixe em branco para 'Pendente')");

        try {
            Task.Status status = Optional.ofNullable(statusStr)
                    .filter(s -> !s.isBlank())
                    .map(Task.Status::fromString)
                    .orElse(Task.Status.PENDENTE);

            Task task = taskController.createTask(title, description, deadline, status);
            view.showMessage("✅ Tarefa criada com sucesso!");
            view.showMessage(task.toString());
        } catch (IllegalArgumentException e) {
            view.showMessage("❌ Erro: " + e.getMessage());
        }
    }
}
