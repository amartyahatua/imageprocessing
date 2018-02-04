import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
public class ShowImage extends Panel {
	static BufferedImage image;
	static public void main(String args[]) throws Exception 
	{

		
		
		
		
		JRadioButton x =new JRadioButton("a");
		
		
		
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		
		String imageName="C:/Documents and Settings/Administrator/Desktop/ah/lena.bmp";
		File input = new File(imageName);
		image = ImageIO.read(input);
		
		JFrame frame =new JFrame("Display image");
		frame.getBaseline(100, 100);
		Panel panel =new ShowImage();
		
		Button button1 = new Button("select"); 
		Button button2 = new Button("reset");
		panel.add(button1);
		panel.add(button2);
		frame.getContentPane().add(panel);
		
		
		button1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		          System.out.println("Button1 pressed");
		        }
		      }); 

		button2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		          System.out.println("Button2 pressed");
		        }
		      }); 
		
		frame.setSize(dim.width, dim.height);
		frame.setVisible(true);				
	}

	public void paint(Graphics g)

	{
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		g.drawImage(image,0,0,(dim.width/3),(dim.height/3), null);
		g.drawImage(image,(dim.height/3),0,(dim.width/3),(dim.height/3), null);
		g.drawImage(image,(dim.height/3),(dim.width/3)+40,(dim.width/3),(dim.height/3), null);
		
	}



}