package guru.springframework;

import java.util.Objects;

public class Money implements Expression {
    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money euro(int amount) {
        return new Money(amount, "EUR");
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money reduce(String to) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }
}
