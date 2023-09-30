package src.model;

import java.time.LocalDate;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToysHouse <E extends Toy> implements Serializable, Iterable<E> {  // E inheritance Human
    private List <E> toyList;
    private String fileName;

    private int ind =1;

    public int getInd(){
        // get max ind in toyList + 1
        ind = 1;
        int i;

        for(E t : toyList){
            i = t.getId();
            if (ind < i) {ind = i;}
        }
        ind += 1;
        return ind;
    }

    public void setFileName(String aFileName){
        this.fileName = aFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public ToysHouse() { toyList = new ArrayList<E>(); }  // constructor

    public ToysHouse(List <E> aList) {  // constructor  from List
        toyList = aList;
    }

    public List <E> addToy(E aToy){  // merge  with  aList
        if (aToy != null) {
            if(!toyList.contains(aToy)){  // only unigue !!!
                aToy.setId(getInd());
                toyList.add(aToy);
            } else {
                // find toy
                E cToy = toyList.get(toyList.indexOf(aToy));
                // add counter to do
                int count = cToy.getCountOfToy() + aToy.getCountOfToy();
                cToy.setCountOfToy( count );
            }
        }
        return toyList;
    }

    // toyHouse.addToy(aName,  aCount,  aWeight);
    public List <E> addToy(String aName, int aCount, int aWeight){  //
        E aToy = (E) new Toy(0, aName, aCount, aWeight);

        if(!toyList.contains(aToy)){  // only unigue !!!
            aToy.setId(getInd());
            toyList.add(aToy);
        } else {
            // find toy
            E cToy = toyList.get(toyList.indexOf(aToy));
            // add counter to do
            int count = cToy.getCountOfToy() + aToy.getCountOfToy();
            cToy.setCountOfToy( count );
        }
        return toyList;
    }

    public List <E> changeToy(String aName, int aCount, int aWeight){  //
        E aToy = (E) new Toy(0, aName, aCount, aWeight);

        if(!toyList.contains(aToy)){  // only unigue !!!
            toyList.add(aToy);
        } else {
            // find toy
            E cToy = toyList.get(toyList.indexOf(aToy));
            cToy.setCountOfToy(aToy.getCountOfToy());
            cToy.setWeigthChance(aToy.getWeigthChance());
        }
        return toyList;
    }

    public List <E> addToyList(List <E> atoyList){  // merge  with  aList
        for (E h: atoyList){
            this.addToy(h);
        }
        return toyList;
    }

    public List <E> getToys(){
        return toyList;
    }

    public E getFirst(){
        if ((toyList.size() > 0) && (toyList.get(0).getCountOfToy() > 0)){
            return toyList.get(0);
        } else {
            return null;
        }
    }

    public E getLast(){
        int iS = toyList.size() - 1;
        if ((iS > 0) && (toyList.get(0).getCountOfToy() > 0)){
            return toyList.get(iS);
        } else {
            return null;
        }
    }

    public String getFilename(){ return fileName; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (toyList.size() != 0){
            for (Toy h: toyList){
                stringBuilder.append(h);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String toStringInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        if (fileName != null){
            stringBuilder.append("\t toyHouse (" + fileName + ")\n");
        } else {
            stringBuilder.append("\t toyHouse (файла нет)\n");
        }
        stringBuilder.append("Игрушки :\n");
        if (toyList.size() != 0){
            stringBuilder.append(this.toString());
        } else {
            stringBuilder.append(" Нет Игрушек ...\n");
        }
        return stringBuilder.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toyList);
    }

    public void sortByName(){
        toyList.sort(new ToyComparatorByName<>());
    }

    public E getByName(String toyName) {
        for (E toy : toyList) {
            if (toy.getName().equalsIgnoreCase(toyName)) {
                return toy;
            }
        }
        return null;
    }
}