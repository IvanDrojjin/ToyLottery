package src.model;

import java.time.LocalDate;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrizHouse <E extends Prize> implements Serializable, Iterable<E>{
    private List <E> toyList;
    private String fileName;

    public PrizHouse() { toyList = new ArrayList<E>(); }  // constructor

    @Override
    public Iterator<E> iterator() {
        return new PrizIterator<>(toyList);
    }

    public void setFileName(String aFileName){
        this.fileName = aFileName;
    }

    public String getFileName() {
            return fileName;

    }

//    addWinner(fooInd, secondArray[1], fooWinner);
    public List <E> addWinner(E aPrize){  // merge  with  aList
        if (aPrize != null) {
                toyList.add(aPrize);
        }
        return toyList;
    }

//    newPrizHouse.addWinner(fooInd, secondArray[1], fooWinner);
    public List <E> addWinner(int aInd, String aName, int aWinner){  //
        E aPriz = (E) new Prize( aInd, aName, aWinner);

        toyList.add(aPriz);
        return toyList;
    }

    public E getByWinner(int iWinner) {
        E at;
        for (E toy : toyList) {
            if (toy.getIdWinner() == iWinner) {
                at = toy;
                toyList.remove(toy);
                return at;
            }
        }
        return null;
    }

    public String toStringInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        if (fileName != null){
            stringBuilder.append("PrizHouse (" + fileName + ")\n");
        } else {
            stringBuilder.append("PrizHouse (файла нет)\n");
        }
        stringBuilder.append("Выигрыши :\n");
        if (toyList.size() != 0){
            stringBuilder.append(this.toString());
        } else {
            stringBuilder.append(" Нет Выигрышей ...\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (toyList.size() != 0){
            for (Prize h: toyList){
                stringBuilder.append(h);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
