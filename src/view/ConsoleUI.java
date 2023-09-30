package src.view;

//import src.model.Gender;
import src.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;  //   DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;
public class ConsoleUI  implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
//    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (menu.work()){
            printMenu();
            execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scanner = new Scanner(System.in, "Cp866");
        return scanner.nextLine();
    }

    public void finish() {
        System.out.println("Приятно было пообщаться...");
    }

//    add lottery  start
//        commandList.add(new RunLottery (consoleUI));
    public void RunLottery() {
        System.out.println("RunLottery.../n");
        presenter.RunLottery();
    }

    public void  ShowToys(){
//        System.out.println("ShowToys.../n");
        presenter.ShowToys();
    }

//        commandList.add(new AddToy (consoleUI));
    public void AddToy() {
//        System.out.println("AddToy.../n");
//       Toy(int id, String toyName, int countOfToy, int weigthChance)

        System.out.print("Введите название игрушки :");
        String aName = scanner.nextLine();

        System.out.print("Введите количество :");
        String aCount = scanner.nextLine();
        int fooCount, fooWeight;

        try {
            fooCount = Integer.parseInt(aCount);
        } catch (NumberFormatException e) {
            fooCount = 0;
        }

        System.out.print("Введите Вероятность :");
        String aWeight = scanner.nextLine();
        try {
            fooWeight = Integer.parseInt(aWeight);
        } catch (NumberFormatException e) {
            fooWeight = 0;
        }

        presenter.AddToy(aName, fooCount, fooWeight);
    }

//        commandList.add(new ChangeToy (consoleUI));
    public void ChangeToy() {
//        System.out.println("ChangeToy.../n");
        System.out.print("Введите название игрушки :");
        String aName = scanner.nextLine();

        System.out.print("Введите количество :");
        String aCount = scanner.nextLine();
        int fooCount, fooWeight;

        try {
            fooCount = Integer.parseInt(aCount);
        } catch (NumberFormatException e) {
            fooCount = 0;
        }

        System.out.print("Введите Вероятность :");
        String aWeight = scanner.nextLine();
        try {
            fooWeight = Integer.parseInt(aWeight);
        } catch (NumberFormatException e) {
            fooWeight = 0;
        }

        presenter.ChangeToy(aName, fooCount, fooWeight);
    }

//        commandList.add(new GetToy (consoleUI));
    public void GetToy() {
        System.out.print("Введите Номер выигрыша :");
        String aWinner = scanner.nextLine();
        int fooWinner;
        try {
            fooWinner = Integer.parseInt(aWinner);
        } catch (NumberFormatException e) {
            fooWinner = -1;
        }

//        System.out.println("GetToy.../n");
        presenter.GetWinner(fooWinner);
    }

//    add lottery  end


//    public void sortByName() {
//        presenter.sortByName();
//    }

//    public void getHumansInfo() {
//        presenter.getHumansInfo();
//    }


//    public LocalDate askBirthDay(){
//        DateTimeFormatter formatterDt;
//        String aPattern = "dd.MM.yyyy";
//        formatterDt = DateTimeFormatter.ofPattern(aPattern);
//
//        boolean dt_good = false; LocalDate lt = LocalDate.now();
//        while (!dt_good){
//            System.out.print("Введите день рождения :");
//            String aBD = scanner.nextLine();
//            lt = LocalDate.parse(aBD, formatterDt);
//            try {  // https://www.programcreek.com/java-api-examples/?api=java.time.format.DateTimeParseException
//                lt = LocalDate.parse(aBD, formatterDt);  dt_good = true;
//            } catch (DateTimeParseException e) {
//                System.out.print(e.getMessage());
//                dt_good = false; lt = LocalDate.now();
//            }
//        }
//        return lt;
//    }

//    public void addHuman() {
//        Gender gSex = Gender.Man;
//        DateTimeFormatter formatterDt;
//        formatterDt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//
//        System.out.print("Введите имя человека :");
//        String name = scanner.nextLine();
//        System.out.print("Введите пол :");
//        String aG = "м",   aGendeereStr = scanner.nextLine();
//        if (!aGendeereStr.toLowerCase().contains("м")) {
//            gSex = Gender.Femail;  // aG = "ж";
//        }
//        LocalDate lt = askBirthDay();
//        presenter.addHuman(name, gSex, lt);
//    }

//    public void AddChild(){
//
//        System.out.print("Введите имя Родителя :");
//        String nameP = scanner.nextLine();
//        LocalDate ltP = askBirthDay();
//
//        System.out.print("Введите имя Ребенка :");
//        String nameCh = scanner.nextLine();
//        LocalDate ltCh = askBirthDay();
//        presenter.addChild(nameP, ltP, nameCh, ltCh);
//    }

//    public void humanSearch() {
//        System.out.print("Введите имя человека для поиска-> ");
//        String name = scan();
//        presenter.humanSearch(name);
//    }

//    public void  humanSearchFamily(){
//        System.out.print("Введите имя человека для поиска-> ");
//        String name = scan();
//        presenter.humanSearchFamily(name);
//    }


    private void hello(){
        System.out.println("\t Toys Lottery \nДоброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[1-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
        System.out.print("Выберите пункт Меню -> ");
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

}
