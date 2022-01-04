package logic;

/*
Class WelcomeLogic Implements the logic of the welcome screen:
 - prints welcome message (if requested)
 - prints conversion options
 - accepts user input
 - validates the input
 - returns the selection
 */

import screens.ScreenAbs;
import screens.UserInput;
import screens.WelcomeScreen;
import java.util.InputMismatchException;

public class WelcomeLogic {

    //defines whether to display a welcome message
    private boolean showWelcome = true;
    //class constructor
    public WelcomeLogic(boolean showWelcome){
        this.showWelcome = showWelcome;
    }
    //sets the welcome message displaying
    public void setShowWelcome(boolean showWelcome) {
        this.showWelcome = showWelcome;
    }

    //Conversion type logic
    public int getConversionType() {

        //user selection
        int selection = 0;

        //initialize a new Welcome Screen with/without the welcome message
        ScreenAbs wScreen = new WelcomeScreen(showWelcome);
        //Print the screen text
        wScreen.printScreenMessage();

       //iterate until correct input is entered (1, 2 or 3)
        while (true){
            try {
                //Get user selection
                selection = UserInput.getInputInt();
                //Check the selection and terminate the input loop with a valid selection
                if (selection == 1 || selection == 2 || selection == 3){
                    break;
                }else
                    wScreen.printErrorMessage();

            } catch (InputMismatchException e) {
                wScreen.printErrorMessage();
            }
        }
        return selection;
    }

}
