package src.view.commands;
import src.view.ConsoleUI;

public class GetToy extends Command {
    public GetToy(src.view.ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить игрушку (по id Выигрыша)";
    }
    public void execute(){
        consoleUI.GetToy();
    }
}