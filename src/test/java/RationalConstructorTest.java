import org.junit.Test;
import static org.junit.Assert.*;

public class RationalConstructorTest {

    @Test
    public void defaultConstructorCreatesZero() {
        Rational r = new Rational();          // 0/1
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void fractionIsReducedOnCreation() {
        Rational r = new Rational(6, 8);      // 6/8 → 3/4
        assertEquals(new Rational(3, 4), r);
    }

    @Test
    public void minusMovesToNumerator() {
        Rational r = new Rational(2, -5);     // 2/-5 → -2/5
        assertEquals(-2, r.getNumerator());
        assertEquals( 5, r.getDenominator());
    }

    @Test
    public void zeroNumeratorGivesDenominatorOne() {
        Rational r = new Rational(0, -7);     // 0/-7 → 0/1
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorThrows() {
        new Rational(1, 0);
    }
}

