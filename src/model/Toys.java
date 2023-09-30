package src.model;

abstract class Toys {

    int id;   //  id игрушки
    String toyName;  // Имя
    int countOfToy;  // количество
    int weigthChance;   // Вероятность

    public Toys(int id, String toyName, int countOfToy, int weigthChance) {
        this.id = id;
        this.toyName = toyName;
        this.countOfToy = countOfToy;
        this.weigthChance = weigthChance;
    }

    public String getName() {
        return toyName;
    }

    public int getCountOfToy() {
        return countOfToy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeigthChance() {
        return weigthChance;
    }

    public String getAllInfo() {
        return id+";"+toyName+";"+countOfToy+";"+ weigthChance;
    }

    public void setWeigthChance(int weigthChance) {
        this.weigthChance = weigthChance;
    }

    public void setCountOfToy(int countOfToy) {
        this.countOfToy = countOfToy;
    }

    @Override
    public String toString() {
        return "Id : " + getId() + ", Имя : " + getName() +
                ", Число : " + getCountOfToy() + ", Вероятность :" + getWeigthChance();
    }
}
