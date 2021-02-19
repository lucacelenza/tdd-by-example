package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testFiveTimesTwo() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.getAmount());
    }

    @Test
    void testFiveTimesThree() {
        Dollar five = new Dollar(5);
        five.times(3);
        assertEquals(15, five.getAmount());
    }

    @Test
    void testImmutability() {
        Dollar five = new Dollar(5);
        Dollar ten = five.times(2);
        assertEquals(10, ten.getAmount());
        Dollar fifteen = five.times(3);
        assertEquals(15, fifteen.getAmount());
    }

    @Test
    void testEquals() {
        assertEquals(new Dollar(5), new Dollar(5));
    }

    @Test
    void testNotEquals() {
        assertNotEquals(new Dollar(5), new Dollar(10));
        assertNotEquals(new Dollar(5), null);
    }
}
