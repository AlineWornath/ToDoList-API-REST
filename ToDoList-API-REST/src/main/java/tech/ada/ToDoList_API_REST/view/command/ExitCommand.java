package tech.ada.ToDoList_API_REST.view.command;

import tech.ada.ToDoList_API_REST.view.View;

public class ExitCommand implements Command {

    private final View view;

    public ExitCommand(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showMessage("Saindo... 👋");
        System.exit(0);
    }
}
