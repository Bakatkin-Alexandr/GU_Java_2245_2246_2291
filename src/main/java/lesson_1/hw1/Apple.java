package lesson_1.hw1;

public class Apple extends Fruit {
    private final float weight = 1.0f;

    public Apple() {;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Orange { weight= %f } %s", weight, "string");
    }

    /*@Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }*/
}
