import org.junit.Test;
import static org.junit.Assert.*;

public class RationalArithmeticTest {

    @Test
    public void additionOfPositiveFractions() {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        assertEquals(new Rational(5, 6), a.plus(b));
    }

    @Test
    public void subtractionWithNegativeResult() {
        Rational a = new Rational(2, 3);
        Rational b = new Rational(5, 6);
        assertEquals(new Rational(-1, 6), a.minus(b));
    }

    @Test
    public void multiplicationWithSigns() {
        Rational a = new Rational(-2, 5);
        Rational b = new Rational(5, 7);
        assertEquals(new Rational(-2, 7), a.multiply(b));
    }

    @Test
    public void divisionProducesCorrectFraction() {
        Rational a = new Rational(3, 4);
        Rational b = new Rational(-2, 3);
        assertEquals(new Rational(-9, 8), a.divide(b));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroFractionThrows() {
        Rational a = new Rational(1, 3);
        Rational zero = new Rational(0, 5);   // 0
        a.divide(zero);
    }
}

