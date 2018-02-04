import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


public class last {
	public static void main(String args[]) throws IOException
	{
		FileInputStream fstream = new FileInputStream("C:/Documents and Settings/Administrator/Desktop/ah/pixel.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  int counter=0;
		  while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		  
		  }
		  //Close the input stream
		  for(int x=0;x<512;x++)
		  {
			  for(int y=0;y<512;y++)
			  {
				  strLine = br.readLine();
				  System.out.println (strLine);
				  counter++;
			  }
		  }
		  in.close();
		  System.out.println(counter);
		
		
		
		
	}

}
