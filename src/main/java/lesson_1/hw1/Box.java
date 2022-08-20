package lesson_1.hw1;

import java.util.List;

public class Box <T extends Fruit>{
    private final List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }
    public boolean compare(Box<?> box){
        this.getWeight();
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void switchFruitsToAnotherBox(Box<T> box){
        for (T fruit : this.fruits) {
            box.addFruit(fruit);
        }
        this.fruits.clear();
    }
}
