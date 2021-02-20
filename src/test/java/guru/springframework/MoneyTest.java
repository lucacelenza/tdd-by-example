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
        assertNotEquals(Money.dollar(5), Money.euro(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("EUR", Money.euro(1).getCurrency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.getAugmend());
        assertEquals(five, sum.getAddend());
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
}
