package lesson_6.hw;

public class CheckArray {
    private int [] array;

    public CheckArray() {
    }

    public boolean checkArray (int [] arr){
        this.array = arr;
        int one = 0;
        int four = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4){
                return false;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 1){
                one++;
            } else {
                four++;
            }
        }
        if (one == 0 || four == 0){
            return false;
        }
        return true;
    }
}
