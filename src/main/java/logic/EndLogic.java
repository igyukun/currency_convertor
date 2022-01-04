package logic;

/*
Class EndLogic implements the logic required to finalize the conversion flow.
The constructor arguments:
 - a list of conversions
 - a path of the file to write a conversion data into

 The flow is:
 - Display End Screen, which outputs the list of the last session's conversions
 - Write the list of conversions into the file (append to an existing data with a timestamp)
 */

import screens.EndScreen;
import screens.ShowFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EndLogic {

    private List<String> list;      //a list of results to be printed
    private String fileName = "";   //file path to print a conversion results into

    //constructor receives and initializes the file path and the list of conversions
    public EndLogic(String fileName, List<String> list){
        this.fileName = fileName;
        this.list = list;
    }

    //implements the EndScreen logic
    public void displayEndScreen(){
        //instantiate a new EndScreen by passing it the list of conversions
        //and print the list to a console
        EndScreen screen = new EndScreen(list);
        screen.printScreenMessage();
        try {
            //write the list into the file
            writeListToFile();
        }catch (IOException e){
            System.out.println("IOException was thrown: " + e.getMessage());
        }
    }

    //Write the list contents into the file
    private void writeListToFile() throws IOException {
        Path path = Paths.get(fileName);
        String header = String.format("%n[%s]%n" +
                                        "===== Start of list ====%n",
                                        getCurrentTimestamp());
        String footer = String.format("====== End of list ======%n");

        // Create the file if does not exist
        if (!Files.exists(path))
            Files.createFile(path);

        // Print the header of the list
        Files.writeString(path,header, StandardOpenOption.APPEND);

        //print the list contents
        for (String s: list){
            Files.writeString(path,String.format("%s%n",s), StandardOpenOption.APPEND);
        }
        //print the footer of the list
        Files.writeString(path,footer, StandardOpenOption.APPEND);

        //Draw the file contents using SWING
        ShowFile t = new ShowFile();
        t.drawText(fileName);

        //Open file in Notepad application
        openFileInNotepad(path);
    }

    // The method returns current timestamp in the format of yyyy/MM/dd HH:mm:ss
    private String getCurrentTimestamp(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    //The method opens the file with a notepad application.
    public void openFileInNotepad(Path path){
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("notepad " + path.toAbsolutePath().toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
