import lesson_6.Calculator;
import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        System.out.println("NEW CALCULATOR");
        calculator = new Calculator();
        calculator.setA(2);
        calculator.setB(4);
    }

    @Test
    public void testCalcSum(){
        Assertions.assertEquals(4, calculator.sum(1, 3));
    }

    @Test
    public void testCalcWrongSum(){
        Assertions.assertNotEquals(4, calculator.sum(2, 3));
    }

    @Test
    public void testCalcSumWithNull(){
        Assertions.assertEquals(7, calculator.sum(7, 0));
    }

    @Test
    public void testCalcInnerSum1(){
        calculator.setA(1);
        calculator.setB(3);
        Assertions.assertEquals(4, calculator.sum(1, 3));
    }

    @Test
    public void testCalcInnerSum2(){
        Assertions.assertEquals(6, calculator.sum());
    }

    @AfterAll
    public void end(){
        System.out.println("END");
    }
}
