package coins;
/*
Class coin factory implements Factory DP
and returns an instant of the relevant class
according to the Coins enum value
 */

public class CoinFactory {

    public static Coin getCoinInstance(Coins coin) {

        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            case EUR:
                return new EUR();
        }

        return null;
    }
}
