package src.presenter;

import src.model.*;
import src.view.View;
import java.io.IOException;

import src.model.Service;
import src.view.ConsoleUI;
import src.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {
    private View view;
//    private HumanTree<Human> humansTreeConnect;
    private ObjIO serialize;

    private ToyComparatorByName sortName;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

// ***************************************************
//    add lottery  start

    //        commandList.add(new RunLottery (consoleUI));
    public void RunLottery() {
        String str = service.RunLottery();
        view.printAnswer(str);
    }

    public void ShowToys() {
        view.printAnswer(service.ShowToys());
    }

    //        commandList.add(new AddToy (consoleUI));
    public void AddToy(String aName, int aCount, int aWeight) {  // presenter.AddToy(aName, fooCount, fooWeight);
        service.AddToy( aName,  aCount,  aWeight);
    }

    //        commandList.add(new ChangeToy (consoleUI));
    public void ChangeToy(String aName, int aCount, int aWeight) {
        service.ChangeToy( aName,  aCount,  aWeight);
    }

    //        commandList.add(new GetToy (consoleUI));
    public void GetToy() {
//        service.GetToy();
    }

    public void GetWinner(int fooWinner){
        String sA = service.GetWinner(fooWinner);
        view.printAnswer(sA);
    }

//    add lottery  end
// ***************************************************


    // Presenter(view, newToysHouse, newPrizHouse, serialize, sortName);
    public Presenter(View view, ToysHouse<Toy> familyConnect, src.model.PrizHouse<Prize> prizHouse,
                     ObjIO serialize, ToyComparatorByName sortAge) {
        this.view = view;
        this.service = new Service(familyConnect, prizHouse);
        this.serialize = serialize;
        this.sortName = sortAge;
        view.setPresenter(this);

        serialize.readFileTXT(familyConnect.getFileName());
    }


}
