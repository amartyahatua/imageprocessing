import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BrowsePath extends JFrame implements ActionListener {

	JButton button;
	JTextField field;
	String imageName = null;
	static BufferedImage image1;

	public BrowsePath () {
		this.setLayout(null);

		button = new JButton("browse");
		field = new JTextField();

		field.setBounds(30, 50, 200, 25);
		button.setBounds(240, 50, 100, 25);
		this.add(field);
		this.add(button);

		button.addActionListener(this);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		Chooser frame = new Chooser();
		field.setText(frame.fileName);
		imageName = frame.fileName;
		
		
		
	}

	public static void main(String args[]) {
		
		
		
		
		String imageName1="C:/Documents and Settings/Administrator/Desktop/ah/lena.bmp";
		File input1 = new File(imageName1);
		try {
			 image1 = ImageIO.read(input1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		

		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		BrowsePath frame = new BrowsePath ();
		//frame.setSize(400, 300);
		//frame.setLocation(200, 100);
		Graphics g =null;
		//g.drawImage(image1,0,0,null);
		frame.setVisible(true);
	}
	
	
	
	
	
	public void paint(Graphics g)

	{	
		//Graphics graphics=image1.getGraphics();
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();

		//graphics.drawImage(image2,0,0,(dim.width/3),(dim.height/3), null);
		g.drawImage(image1,0,0, null);
		//g.drawImage(image2,(dim.height/3),0,(dim.width/3),(dim.height/3), null);
		//g.drawImage(image,(dim.height/3),(dim.width/3)+40,(dim.width/3),(dim.height/3), null);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

class Chooser extends JFrame {

	JFileChooser chooser;
	String fileName;

	public Chooser() {
		chooser = new JFileChooser();
		int r = chooser.showOpenDialog(new JFrame());
		if (r == JFileChooser.APPROVE_OPTION) {
			fileName = chooser.getSelectedFile().getPath();
		}
	}
	
	
	
	
	
}