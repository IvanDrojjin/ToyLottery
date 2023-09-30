//package src;

package src.view;

import src.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private boolean work;
    private List<Command> commandList;

//1. Выход                  Finish
//2. Разыграть игрушку      RunLottery
//   Вывести список игрушек
//3. Добавить игрушку       AddToy
//4. Изменить вероятность выигрыша игрушки  ChangeToy
//5. Получить игрушку       GetToy


    public MainMenu(ConsoleUI consoleUI) {
        work = true;
        commandList = new ArrayList<>();
        commandList.add(new Finish(consoleUI));  //  1 ==> EXIT  +++
        commandList.add(new RunLottery (consoleUI));  // +++ ---
        commandList.add(new ShowToys (consoleUI));  // +++
        commandList.add(new AddToy (consoleUI));  // +++
        commandList.add(new ChangeToy (consoleUI));  // +++
        commandList.add(new GetToy (consoleUI));  // +++

//        commandList.add(new  (consoleUI));
    }

    public boolean work(){return work;}
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
//        if (num > 0 && num <= commands.size()){
        if (choice == 1) work = false;
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
