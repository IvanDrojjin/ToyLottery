package src.view.commands;
import src.view.ConsoleUI;

public class AddToy extends Command {
    public AddToy(src.view.ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушку";
    }
    public void execute(){
        consoleUI.AddToy();
    }
}