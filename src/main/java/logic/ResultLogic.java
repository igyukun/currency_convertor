package logic;

/*
Class ResultLogic implements the logic to be used with ResultScreen and performs everything in
'convert' method:
 - receives in the constructor the amount and the conversion type
 - creates Coin instance (USD-ILS or ILS-USD)
 - calculates the converted value
 - displays the Result screen with a result
 - requests from user a Start-Over directive (Y/N)
 - validates the response and updates the private parameter.
 */
import coins.Coin;
import coins.CoinFactory;
import coins.Coins;
import screens.ResultScreen;
import screens.UserInput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ResultLogic {

    private double amount;                  //amount of a currency to convert
    private int conversionType;             //the conversion type (USD->ILS, ILS->USD or ILS->EUR)
    private String resultMessage = "No conversion was made";
    private boolean isStartOver = false;    //User choice of Starting Over
    private ResultScreen screen = null;     //ResultScreen object - accessed from two methods

    //Constructor. Creates the class instance and initializes the class properties:
    // currency amount and conversion type
    public ResultLogic(double amount, int conversionType){
        this.amount = amount;
        this.conversionType = conversionType;
    }

    //performs the conversion and returns the formatted result string
    public String getConversion(){
        Coin coin = null;
        double result;

        //Create the relevant coin class instance using the Factory
        switch (conversionType){
            case 1:
               coin = CoinFactory.getCoinInstance(Coins.USD);
               break;
            case 2:
               coin = CoinFactory.getCoinInstance(Coins.ILS);
               break;
            case 3:
                coin = CoinFactory.getCoinInstance(Coins.EUR);
                break;
        }

        //convert the currency
        result = coin.calculate(amount);
        //create formatted result string
        resultMessage = buildResultString(result);
        //instantiate the result screen and print the formatted results
        screen = new ResultScreen(resultMessage);
        screen.printResultMessage();
        //prompt user for a start-over and read an input
        screen.printScreenMessage();
        getStartOverOption();
        //return the formatted conversion result
        return resultMessage;
    }

    //build a formatted result string, e.g. "XX.xx USD = YY.yy ILS"
    private String buildResultString(double result){
        String message = "";
        switch (conversionType){
            case 1:
                message =  String.format("%.2f USD = %.2f ILS", amount, result);
                break;
            case 2:
                message =  String.format("%.2f ILS = %.2f USD", amount, result);
                break;
            case 3:
                message =  String.format("%.2f ILS = %.2f EUR", amount, result);
                break;
        }
        return message;
    }

    //Prompt user for a start-over choice and validate an input.
    private void getStartOverOption(){

        String selection = "";

        //iterate until correct input is entered ('Y' or 'N' case insensitive)
        while (true){
            selection = UserInput.getInputString();
            //Check the selection and terminate the input loop with a valid selection
            if (selection.equalsIgnoreCase("y")) {
                isStartOver = true;
                break;
            } else if(selection.equalsIgnoreCase("n")) {
                isStartOver = false;
                break;
            } else {
                //print invalid selection message
                screen.printErrorMessage();
            }
        }
    }

    //return the user start-over selection
    public boolean isStartOver() {
        return isStartOver;
    }

}
