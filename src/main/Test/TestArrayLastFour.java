import lesson_6.hw.ArrayLastFour;
import lesson_6.hw.MyArrayExceptionNotFour;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayLastFour {
    @Test
    void testArray() {
        ArrayLastFour arrayLastFour = new ArrayLastFour();
        int [] array1 = {10, 2, 4, 2, 6, 2};
        int [] arrayTest1 = arrayLastFour.cutArray(array1);
        int [] arrayRes1 = {2, 6, 2};
        assertArrayEquals(arrayRes1, arrayTest1, "Неверное преобразование массива");

        int [] array2 = {4, 2, 2, 2, 6, 2};
        int [] arrayTest2 = arrayLastFour.cutArray(array2);
        int [] arrayRes2 = {2, 2, 2, 6, 2};
        assertArrayEquals(arrayRes2, arrayTest2, "Неверное преобразование массива");

        int [] array3 = {4, 2, 4, 2, 4, 2};
        int [] arrayTest3 = arrayLastFour.cutArray(array3);
        int [] arrayRes3 = {2};
        assertArrayEquals(arrayRes3, arrayTest3, "Неверное преобразование массива");

        int [] array4 = {10, 2, 7, 8, 8, 4};
        int [] arrayTest4 = arrayLastFour.cutArray(array4);
        int [] arrayRes4 = {};
        assertArrayEquals(arrayRes4, arrayTest4, "Неверное преобразование массива");
    }

    @Test
    void testArrayExc() throws IOException {
        ArrayLastFour arrayLastFour = new ArrayLastFour();
        int [] array = {10, 3, 2, 2, 6, 2};

        assertThrows(MyArrayExceptionNotFour.class, () -> arrayLastFour.cutArray(array));
    }
}
