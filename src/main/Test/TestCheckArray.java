import lesson_6.hw.CheckArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCheckArray {
    @Test
    void checkArray() {
        CheckArray checkArray = new CheckArray();
        int [] array1 = {1, 1, 4};
        boolean actual1 = checkArray.checkArray(array1);
        assertTrue(actual1);

        int [] array2 = {1, 2, 4};
        boolean actual2 = checkArray.checkArray(array2);
        assertFalse(actual2);

        int [] array3 = {1, 1, 1};
        boolean actual3 = checkArray.checkArray(array3);
        assertFalse(actual3);

        int [] array4 = {4, 4, 4};
        boolean actual4 = checkArray.checkArray(array4);
        assertFalse(actual4);
    }
}
