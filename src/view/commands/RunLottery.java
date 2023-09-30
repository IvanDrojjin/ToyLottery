package src.view.commands;
import src.view.ConsoleUI;

public class RunLottery extends Command {
    public RunLottery(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Запустить лотерею";
    }
    public void execute(){
        consoleUI.RunLottery();
    }
}

