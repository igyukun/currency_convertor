package screens;
/*
Abstract class implement IScreen interface and creates abstract methods
to be implemented by inheriting class
 */
public abstract class ScreenAbs implements IScreen{
    //Error message
    final String INCORRECT_SELECTION = "Invalid Choice, please try again:";

    @Override
    //Main print message to be implemented by Screens
    public abstract void printScreenMessage();

    @Override
    //Error message print to be implemented by Screens
    public void printErrorMessage(){
        System.out.printf("%s%n", INCORRECT_SELECTION);
    }





}
