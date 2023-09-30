package src.view.commands;
import src.view.ConsoleUI;

public class ChangeToy extends Command {
    public ChangeToy(src.view.ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить игрушку (Вероятность выигрыша, количество)";
    }
    public void execute(){
        consoleUI.ChangeToy();
    }
}