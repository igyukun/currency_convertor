package coins;


/**
 * Class that represents EUR currency and implements getValue() method of
 * abstract class Coin
 */
public class EUR extends Coin{

    private final double value = 4.23;       //Default ILS to USD conversion rate

    @Override
    public double getValue() {
        return 1/value;
    }

    @Override
    public double calculate(double amount) {
        return amount * getValue();
    }
}

