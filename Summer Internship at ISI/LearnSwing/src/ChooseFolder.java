import javax.swing.*;
import java.io.*;

public class ChooseFolder
{
public static void main(String[] args)
{
JFileChooser chooser = new JFileChooser();
chooser.setLocation(300, 300);
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
if (JFileChooser.APPROVE_OPTION==chooser.showDialog(null, "Select"))
{
File dir = chooser.getSelectedFile();
System.out.println(dir);
}
System.exit(0);
}
}