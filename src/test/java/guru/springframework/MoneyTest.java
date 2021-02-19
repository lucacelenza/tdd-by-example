package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Dollar firstMultiplication = five.times(2);
        assertEquals(10, firstMultiplication.getAmount());
        Dollar secondMultiplication = five.times(3);
        assertEquals(15, secondMultiplication.getAmount());
    }
}
