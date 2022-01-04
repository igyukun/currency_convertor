package screens;

/**
 * Class WelcomeScreen prints the welcome message if requested using constructor
 * and prompts user to select conversion currency
 */
public class WelcomeScreen extends ScreenAbs {

    private boolean isShowWelcome = true;  //defines whether to print a welcome message
    private final String WELCOME_MESSAGE = "Welcome to currency converter";
    private final String MAIN_MESSAGE = String.format("Please choose an option (1/2): %n" +
                                                      "1. Dollars to Shekels%n" +
                                                      "2. Shekels to Dollars%n" +
                                                      "3. Shekels to Euro");

    //constructor creates an object and inits a show welcome message property
    public WelcomeScreen (boolean isShowWelcome) {
        this.isShowWelcome = isShowWelcome;
    }

    @Override
    //print a screen message
    public void printScreenMessage() {
        if (isShowWelcome){
            //With welcome message
            System.out.println(WELCOME_MESSAGE);
        }
        System.out.println(MAIN_MESSAGE);
    }

    //Set a show welcome message property
    public void setShowWelcome(boolean showWelcome) {
        isShowWelcome = showWelcome;
    }

}
