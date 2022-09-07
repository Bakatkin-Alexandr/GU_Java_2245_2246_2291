package lesson_6.hw;

public class ArrayLastFour {
    private int [] arr;
    private int [] cutArr;

    public ArrayLastFour() {
    }

    public int[] cutArray (int[] arr){
        this.arr = arr;
        isFourInArr(arr);
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4){
                temp = arr.length - i - 1;
                break;
            }
        }

        this.cutArr = new int[temp];
        int temp1 = 0;
        for (int i = arr.length - temp; i < arr.length; i++) {
            cutArr[temp1] = arr[i];
            temp1++;
        }
        return cutArr;
    }

    private void isFourInArr(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                count++;
            }
        }
        if (count == 0){
            throw new MyArrayExceptionNotFour("В массиве нет числа 4");
        }
    }
}
