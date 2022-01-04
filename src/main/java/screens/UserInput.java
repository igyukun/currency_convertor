package screens;
/*
UserInput takes care of getting int, double and string input from a console
by using the Scanner API
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public final class UserInput {

    //Get a string from user
    public static String getInputString() {

        Scanner s = new Scanner(System.in);
        return s.next();
    }

    //Get an integer from user
    public static int getInputInt() throws InputMismatchException {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    //Get a double from user
    public static double getInputDbl() throws InputMismatchException {
        Scanner s = new Scanner(System.in);
        return s.nextDouble();
    }
}
