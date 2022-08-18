package lesson_1.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strArr = {"one", "two", "three", "four"};
        Integer[] intArr = {1, 2, 3, 4};
        Double[] doubleArr = {1.1, 1.2, 1.3, 1.4};

        changeElements(strArr, 0, 3);
        swapElements(intArr, 2, 3);
        swapElements(doubleArr, 0, 2);

        //2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<Double> list = (ArrayList<Double>) convertToList(doubleArr);

        System.out.println("------------Third task------------");
        Box<Apple> boxApples = new Box<>(new ArrayList<>());
        for (int i = 0; i < 6; i++) {
            boxApples.addFruit(new Apple());
        }
        Box<Apple> boxApples2 = new Box<>(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            boxApples2.addFruit(new Apple());
        }
        Box<Orange> boxOranges = new Box<>(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            boxOranges.addFruit(new Orange());
        }
        System.out.println(boxApples.getWeight());
        System.out.println(boxOranges.getWeight());
        System.out.println(boxApples.compare(boxOranges));
        boxApples.switchFruitsToAnotherBox(boxApples2);
        System.out.println(boxApples.getWeight());
        System.out.println(boxApples2.getWeight());
    }

    private static <E> void changeElements(E[] arrToTest, int position1, int position2) {
        System.out.println("Original Array:\n" + Arrays.toString(arrToTest));
        swapElements(arrToTest, position1, position2);
        System.out.println("Changed Array:\n" + Arrays.toString(arrToTest));
    }

    private static <F> List<F> convertToList(F[] array) {
        ArrayList<F> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
        List<F> list = Arrays.asList(array);
        System.out.println("Original Array:\n" + array.getClass() + " : " + Arrays.toString(array) +
                "\nModified Array: \n " + list.getClass() + " : " + list);
        return list;
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
