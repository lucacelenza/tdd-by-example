package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    void testImmutabilityDollar() {
        Dollar five = new Dollar(5);
        Dollar ten = five.times(2);
        assertEquals(10, ten.getAmount());
        Dollar fifteen = five.times(3);
        assertEquals(15, fifteen.getAmount());
    }

    @Test
    void testEqualsDollar() {
        assertEquals(new Dollar(5), new Dollar(5));
    }

    @Test
    void testNotEqualsDollar() {
        assertNotEquals(new Dollar(5), new Dollar(10));
        assertNotEquals(new Dollar(5), null);
    }

    @Test
    void testMultiplicationFranc() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    void testImmutabilityFranc() {
        Franc five = new Franc(5);
        Franc ten = five.times(2);
        assertEquals(10, ten.getAmount());
        Franc fifteen = five.times(3);
        assertEquals(15, fifteen.getAmount());
    }

    @Test
    void testEqualsFranc() {
        assertEquals(new Franc(5), new Franc(5));
    }

    @Test
    void testNotEqualsFranc() {
        assertNotEquals(new Franc(5), new Franc(10));
        assertNotEquals(new Franc(5), null);
    }

    @Test
    void testNotEquals() {
        assertNotEquals(new Dollar(5), new Franc(5));
    }
}
