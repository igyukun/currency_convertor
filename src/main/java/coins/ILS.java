package coins;

/**
 * Class that represents ILS currency and implements getValue() method of
 * abstract class Coin
 */
public class ILS extends Coin{

    private final double value = 0.28;       //Default ILS to USD conversion rate

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * getValue();
    }
}
