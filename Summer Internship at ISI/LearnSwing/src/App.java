import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class App 
{
	public static void main(String args[])
	{
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() 
			{
				
				JFrame frame = null;
				try {
					frame = new MainFrame("Hello world swing");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			
		});
		
		
		
			//ImageIcon image = new ImageIcon( "C:/Documents and Settings/Administrator/Desktop/ah/mixer.jpg" );
		
		
	}

}
