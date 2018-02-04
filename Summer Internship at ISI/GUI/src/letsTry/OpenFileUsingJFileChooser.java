package letsTry;



import java.io.*;
import javax.swing.*;
class OpenFileUsingJFileChooser{
    public static void main(String[] args)throws Exception{
        JFileChooser chooser=new  JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        File f = chooser.getSelectedFile();
        BufferedReader br=new BufferedReader(new FileReader(f));
        String st="";
        while((st=br.readLine())!=null){
            System.out.println(st);
        }
      }
    }
}

