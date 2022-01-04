package screens;
/*
Class TextArea draws the contents of a text file using SWING library
 */

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

public class ShowFile {

    //Method receives the file name and draws its contents using a JFrame
    public void drawText(String fileName) {

        //Create JFrame instance and define its behavior
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(fileName);
        frame.setSize(400,300);

        //Create JFrame instance and define its behavior
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));

        //Read the file contents into the text area
        try{
            area.read(new BufferedReader(new FileReader(fileName)), null);
        }catch (Exception e) {e.printStackTrace();}

        //Add text area into the frame, using the JScrollPane object and make it visible
        frame.add(new JScrollPane(area));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
