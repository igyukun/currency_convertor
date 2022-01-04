package execution;

import logic.ChoiceLogic;
import logic.EndLogic;
import logic.ResultLogic;
import logic.WelcomeLogic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ConvertorApp {

    private static final String fileName = "converts.txt"; //output file path

    public static void main(String[] args) {

        List<String> conversionsList = new ArrayList<>(); //Results list
        boolean isStartOver = false;                      //User directive for another conversion
        double amount = 0;                                // Amount for conversion
        int conversionType = 0;                           // Conversion type

        //Initialize a welcome screen with a default start over option (false)
        WelcomeLogic welcomeLogic = new WelcomeLogic(isStartOver);

        //iterate until the user terminates by pressing 'N' option
        while (true) {
            //Set show welcome message to true (opposite of is StartOver)
            welcomeLogic.setShowWelcome(!isStartOver);
            //Get a conversion type from user
            conversionType = welcomeLogic.getConversionType();
            //Create a new amount choice logic and get an amount from user
            ChoiceLogic choiceLogic = new ChoiceLogic();
            amount = choiceLogic.getAmount();
            //Create a new result logic and get result as a formatted string
            ResultLogic resultLogic = new ResultLogic(amount, conversionType);
            //Add the current result into the list
            conversionsList.add(resultLogic.getConversion());
            //Check a user start-over choice
            if (!resultLogic.isStartOver())
                //terminate the loop if false
                break;
            else
                //set the local start over to true and re-iterate
                isStartOver = true;
        }

        //finalize the conversion process and write the data into the file
        EndLogic endLogic = new EndLogic(fileName, conversionsList);
        endLogic.displayEndScreen();

    }


}



