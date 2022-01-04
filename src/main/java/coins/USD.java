package coins;

/**
 * Class that represents USD currency and implements getValue() method of
 * abstract class Coin
 */
public class USD extends Coin{

    private final double value = 3.52;   //Default USD to ILS conversion rate

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * getValue();
    }
}
