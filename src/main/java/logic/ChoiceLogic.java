package logic;

/*
ChoiceLogic Class implements the logic related to a currency amount selection
 - create an instance of the ChoiceScreen class
 - Display the message
 - request and validate user input for amount of the selected currency  (double)
 - return a valid value
 */

import screens.ChoiceScreen;
import screens.ScreenAbs;
import screens.UserInput;
import java.util.InputMismatchException;


public class ChoiceLogic {

    //Implement the amount input logic
    public double getAmount(){

        //user selection
        double amount = 0;

        //initialize a new Choice Screen to request an amount
        ScreenAbs chScreen = new ChoiceScreen();
        //print the screen text
        chScreen.printScreenMessage();

        //iterate until a valid input is entered (double number)
        while (true){
            try {
                //Get user selection
                amount = UserInput.getInputDbl();
                if (amount <= 0)
                    chScreen.printErrorMessage();
                else
                    break;
            } catch (InputMismatchException e) {
                chScreen.printErrorMessage();
            }
        }
        return amount;
    }
}


