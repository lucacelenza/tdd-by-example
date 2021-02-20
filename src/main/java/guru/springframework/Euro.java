package guru.springframework;

public class Euro extends Money {
    public Euro(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.euro(amount * multiplier);
    }
}
