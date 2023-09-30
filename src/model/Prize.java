package src.model;

public class Prize {
    int id;   //  id игрушки
    String toyName;  // Имя
    int idWinner;  // код выигрыша

    public Prize(int id, String toyName, int aWinner) {
        this.id = id;
        this.toyName = toyName;
        this.idWinner = aWinner;
    }
    public int getId(){
        return this.id;
    }

    public String getToyName(){ return this.toyName; }

    public int getIdWinner(){ return this.idWinner; }

    @Override
    public String toString(){
        return id + ";" + toyName + ";" + idWinner;
    }
}
