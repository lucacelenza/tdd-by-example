package guru.springframework;

import java.util.Hashtable;

public class Bank {
    private final Hashtable<Pair, Integer> rates;

    public Bank() {
        rates = new Hashtable<>();
    }

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public int rate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) return 1;
        return rates.get(new Pair(fromCurrency, toCurrency));
    }

    public void addRate(String fromCurrency, String toCurrency, int rate) {
        rates.put(new Pair(fromCurrency, toCurrency), rate);
    }
}
