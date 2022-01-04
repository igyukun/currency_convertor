package coins;

/**
 * Abstract class to be inherited by specific currencies' classes
 */
public abstract class Coin implements ICalculate {

    //getValue public method to be implemented or abstracted by inheriting classes
    public abstract double getValue();

    @Override
    public abstract double calculate(double amount);

}
