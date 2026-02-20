import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTest {
    Calculator c;

    @Test
    void testAdd(){
        int r=c.add(2,3);
        assertEquals(5,r);
    }
    @Test
    void testDiv(){
        int r1=c.div(99999999,99999999);
        assertEquals(1,r1);
    }
    @Test
    void testAssertionDivideByZero(){
        assertThrowsExactly(ArithmeticException.class,()->c.div(10,0),"HI PARIWESH SIR");
    }

    @BeforeEach
    void setUp(){
        c =new Calculator();
    }
}
