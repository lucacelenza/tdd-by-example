package guru.springframework;

public class Sum implements Expression {
    private final Money augmend;
    private final Money addend;

    public Sum(Money augmend, Money addend) {
        this.augmend = augmend;
        this.addend = addend;
    }

    public Money getAugmend() {
        return augmend;
    }

    public Money getAddend() {
        return addend;
    }

    public Money reduce(String to) {
        int amount = augmend.getAmount() + addend.getAmount();
        return new Money(amount, to);
    }
}
