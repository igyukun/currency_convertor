package screens;

/*
Results screen implements the screen to show the result of a current conversion
- prints the formatted result string passed in a constructor
- prints the start-over message
 */

public class ResultScreen extends ScreenAbs {

    private String result;       //result placeholder
    private final String MAIN_MESSAGE = "Do you want to start over? (Y/N): ";

    //constructor initializes the result property
    public ResultScreen(String result){
        this.result = result;
    }

    @Override
    //Prints the main screen message
    public void printScreenMessage() {
        System.out.printf("%s%n", MAIN_MESSAGE);
    }

    //Prints the result passed from the instantiator
    public void printResultMessage(){
        System.out.printf("The result is: %s%n", result);
    }

}
