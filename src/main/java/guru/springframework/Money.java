package guru.springframework;

import java.util.Objects;

public abstract class Money {
    protected final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money euro(int amount) {
        return new Euro(amount, "EUR");
    }

    public abstract Money times(int multiplier);

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
