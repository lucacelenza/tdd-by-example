package guru.springframework;

public class Sum implements Expression {
    private final Expression augmend;
    private final Expression addend;

    public Sum(Expression augmend, Expression addend) {
        this.augmend = augmend;
        this.addend = addend;
    }

    public Expression getAugmend() {
        return augmend;
    }

    public Expression getAddend() {
        return addend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).getAmount() +
                addend.reduce(bank, to).getAmount();

        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(
                augmend.times(multiplier),
                addend.times(multiplier)
        );
    }
}
