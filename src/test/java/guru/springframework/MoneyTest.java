package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
    }

    @Test
    void testNotEquality() {
        assertNotEquals(Money.dollar(5), Money.dollar(10));
        assertNotEquals(Money.dollar(5), null);
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }
}
