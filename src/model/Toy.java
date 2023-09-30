package src.model;

public class Toy extends Toys{

    public Toy(int id, String toyName, int countOfToy, int weigthChance) {
        super(id, toyName, countOfToy, weigthChance);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){return true;}
        if (!(obj instanceof Toy)){return false;}
        src.model.Toy ahM = (src.model.Toy) obj;
        return (toyName.equals(ahM.toyName)); // имя &&

    }

    @Override
    public String toString(){
        return super.getAllInfo();
    }
}
