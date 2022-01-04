package screens;

/*
Choice screen - displays messages for a currency amount input
 */
public class ChoiceScreen extends ScreenAbs {
    public final String MAIN_MESSAGE = "Please enter an amount to convert";

    @Override
    public void printScreenMessage(){
        System.out.printf("%s%n", MAIN_MESSAGE);
    }

}
