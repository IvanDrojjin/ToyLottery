package src.model;

import src.model.ToysHouse;
import src.model.Toy;

import src.model.PrizHouse;
import src.model.Prize;

import java.io.IOException;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    private ToysHouse toyHouse;

    private PrizHouse prizHouse;

    private String fileName;

    private ObjIO aIO = new ObjIO();

    public Service() {
        toyHouse = new ToysHouse<>();
        prizHouse = new PrizHouse<>();
    }

    public Service(ToysHouse<Toy> toyConnect, PrizHouse<Prize> aPrizHouse) {
        this.toyHouse = toyConnect;
        this.fileName = toyConnect.getFileName();
        this.prizHouse = aPrizHouse;
    }


// ***************************************************
//    add lottery  start

    public double TotalDropRate(){
        double totalDropRate = 0;  // toyHouse

        List <Toy> aList;
        aList =  toyHouse.addToy(null);
        Toy aToy = null;

        for (int j=0; j < aList.size(); j++){
            aToy = aList.get(j);
            if (aToy.getCountOfToy() > 0){ // CountOfToy() == 0 out off play
                totalDropRate += aToy.getWeigthChance();
            }
        }
        return totalDropRate;
    }


    //        commandList.add(new RunLottery (consoleUI));
    public String RunLottery() {
        List <Toy> aList;
        Toy aToy = null;
        aList =  toyHouse.addToy(null);

//        Toy aPriz = null; // toyHouse.getFirst();

        Random random=new Random();
        double forIdUser=random.nextDouble()*1563;

        int idUser=(int)forIdUser;

        String str;
        double totalDropRate = TotalDropRate();
        double randomValue = random.nextDouble() * totalDropRate;
        double currentSum = 0;

        for (int j=0; j < aList.size(); j++){
            aToy = aList.get(j);
            int cnt = aToy.getCountOfToy();
            if ((cnt > 0)){ // CountOfToy() == 0 out off play
                currentSum += aToy.getWeigthChance();
            }
            if ((cnt > 0) && (randomValue <= currentSum)){
                AddToy(aToy.getName(), -1, 0);

                // add to Priz and write
                addWinner(aToy.getId(), aToy.getName(), idUser);
                str = aToy.toString() + "\t" + idUser;
                return "RunLottery \n \t Выигрыш :" + str;
            }
        }
        return "RunLottery \n \t НЕТ Выигрыша !!!";
    }

    public String addWinner(int iD, String aName, int aWinner){
        // create new Winner
        prizHouse.addWinner(iD, aName, aWinner);

        // Save file
        aIO.writeFileTXT(prizHouse.getFileName(), prizHouse.toString());

        return "addWinner  !!! //// \n";
    }

    public String ShowToys() {
//        Load file

        return toyHouse.toStringInfo() + "\t" + prizHouse.toStringInfo();
    }

    //        commandList.add(new AddToy (consoleUI));
    public String AddToy(String aName, int aCount, int aWeight) {
        // create new toy
        toyHouse.addToy(aName,  aCount,  aWeight);

        // Save file
        aIO.writeFileTXT(toyHouse.getFileName(), toyHouse.toString());  // toyHouse.getToys().toString()
        return "AddToy \n";
    }

    //        commandList.add(new ChangeToy (consoleUI));
    public String ChangeToy(String aName, int aCount, int aWeight) {
        // create new toy
        toyHouse.changeToy(aName,  aCount,  aWeight);

        // Save file
        aIO.writeFileTXT(toyHouse.getFileName(), toyHouse.toString());  // toyHouse.getToys().toString()
        return "ChangeToy \n";
    }

    //        commandList.add(new GetToy (consoleUI));
//    public String GetToy() {
//        prizHouse.getToy
//
//
//        // Save file
//
//
//
//        return "GetToy \n";
//    }

    public String GetWinner(int fooWinner){
        Prize aP = prizHouse.getByWinner(fooWinner);   // GetWinner(fooWinner);

        // Save file
        aIO.writeFileTXT(prizHouse.getFileName(), prizHouse.toString());

        if (aP == null) {
            return "Нет выигрыша :" + fooWinner;
        } else {
            return "Выигрыш : " + aP.toString();
        }
    }


//    add lottery  end
// ***************************************************


    public  String loadFromFile(String fileName) {
        ToysHouse aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        aHT = (ToysHouse) aIO.readFile(fileName);

        toyHouse = aHT;
        toyHouse.setFileName(fileName);
        return "ToyHouse load from " + fileName;
    }

    public  String loadFromFileTXT(String fileName) {  //  todo !!!
        ToysHouse aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ArrayList<String> aList = aIO.readFileTXT(fileName);

        // print aList
        System.out.println("loadFromFileTXT \n" + fileName);
        System.out.println(aList.toString());


        toyHouse.setFileName(fileName);
        return "ToyHouse load from " + fileName;
    }


    public  String addFromFile(String fileName)  throws IOException, ClassNotFoundException    {
        ToysHouse aHT;
        // Востановление из файла с помощью класса ObjectInputStream

        aHT =  (ToysHouse) aIO.readFile(fileName);   //

//        toyHouse.addToyHouse(aHT.getToys());
        toyHouse.setFileName(fileName);
        return "ToyHouse add from " + fileName;
    }

    public  String  saveToFile(String fileName) {
        //Сериализация в файл с помощью класса ObjectOutputStream

        aIO.writeFile(fileName, (Serializable) toyHouse);

        toyHouse.setFileName(fileName);
        return "ToyHouse save to " + fileName;
    }

    public String ToySearch(String name) {
        Toy toy = toyHouse.getByName(name);
        if (toy == null)
            return "Нет игрушки ! " + name;
        else {
            return toy.toString();
        }
    }

    public  Toy  getByName(String name) {
        return toyHouse.getByName (name);
    }

    public String getTreeInfo() {
        return toyHouse.toString();
    }
    public void sortByName(){
        toyHouse.sortByName();
    }

}
