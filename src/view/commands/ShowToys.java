package src.view.commands;
import src.view.ConsoleUI;

public class ShowToys extends Command {
    public ShowToys(src.view.ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все игрушки";
    }
    public void execute(){
        consoleUI.ShowToys();
    }
}