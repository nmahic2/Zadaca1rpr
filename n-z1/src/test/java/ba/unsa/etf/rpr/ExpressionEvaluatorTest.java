package ba.unsa.etf.rpr;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
    ExpressionEvaluator e=new ExpressionEvaluator();
    @Test
    void evaluate() {
        assertEquals(e.evaluate("( 1 + 2 )"),3.0);
    }
    @Test
    void evaluate1() {

        assertEquals(e.evaluate("( 3 - ( 8 + ( 2 - 3 ) ) )"),-4.0);
    }
    @Test
    void evaluate2() {

        assertEquals(e.evaluate("( 8 + ( 2 * ( 4 + 3 ) ) )"),22.0);
    }
    @Test
    void evaluate3() {

        assertEquals(e.evaluate("( 1 / 2 )"),0.5);
    }
    @Test
    void evaluate4() {

        assertEquals(e.evaluate("( 3 + ( sqrt ( 2 + 2 ) ) )"),5.0);
    }
    @Test
    void izuzetak(){
        Exception exception = assertThrows(RuntimeException.class,() -> {
            e.evaluate("( 1 + dfaf )");
        },"Neispravan izraz!");


    }
}