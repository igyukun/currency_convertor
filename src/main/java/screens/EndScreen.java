package screens;

/*
EndScreen implements the final screen of the flow
- receives list of the conversions done in the current session
- prints the "Thank you" message and the list to the console
 */

import java.util.List;

public class EndScreen extends ScreenAbs {

    private List <String> resultsList = null;

    public final String MAIN_MESSAGE = "Thanks for using our currency converter.";


    public EndScreen (List <String> resultsList){
        this.resultsList = resultsList;
    }
    public EndScreen () {}

    @Override
    public void printScreenMessage() {
        System.out.println(MAIN_MESSAGE);
        System.out.printf("%nThe list of conversions:%n" +
                          "==========================%n");
        if (resultsList.isEmpty())
            System.out.print("No conversions have been requested");
        else
            printList();
    }

    private void printList(){

            for (String s : resultsList) {
                System.out.printf("    %s%n", s);
            }

    }

    public void setResultsList(List<String> resultsList) {
        this.resultsList = resultsList;
    }
}
