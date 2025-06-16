import org.junit.Test;
import static org.junit.Assert.*;

public class RationalComparisonTest {

    @Test
    public void equalityIgnoresForm() {
        assertEquals(new Rational(1, 2), new Rational(2, 4));
    }

    @Test
    public void lessReturnsTrueForSmallerFraction() {
        Rational half   = new Rational(1, 2);
        Rational three4 = new Rational(3, 4);
        assertTrue(half.less(three4));
        assertFalse(three4.less(half));
    }

    @Test
    public void lessOrEqualWorksForEqualAndLess() {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(3, 5);
        assertTrue(a.lessOrEqual(b));                   // a < b
        assertTrue(a.lessOrEqual(new Rational(2, 4)));  // a == 1/2
        assertFalse(b.lessOrEqual(a));                  // b > a
    }
}

