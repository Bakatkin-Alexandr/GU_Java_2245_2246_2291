package lesson_1.hw1;

public class Orange extends Fruit {
    private final float weight = 1.5f;

    public Orange() {;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }

    public String info(){
        return "Вес одного апельсина равен" + weight;
    }

    /*@Override
    public String toString() {
        return String.format("Orange{ weight=%f }", weight);
    }*/
}
