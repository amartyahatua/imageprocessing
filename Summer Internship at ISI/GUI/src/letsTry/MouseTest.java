package letsTry;

import java.awt.*;  
import java.awt.event.*;  

import javax.swing.*;  

public class MouseTest implements MouseListener 
{  
	public static void main(String[] args)  
	{  
		JFrame f = new JFrame();  
		MouseTest test = new MouseTest();   
		JPanel panel = new JPanel();
		//panel.setLayout(null);
		
		String path = "C:/Documents and Settings/Administrator/Desktop/test/milk.png";
		//String path1 = "C:/Documents and Settings/Administrator/Desktop/test/balls.png";
		JLabel label = new JLabel();
		label.setBounds(0, 0, 100,100);
		ImageIcon img = new ImageIcon(path);
		
		label = new JLabel( img);
		GridBagConstraints c =new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		
		
		panel.add(label,c);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		f.setContentPane(panel); 
		f.addMouseListener(test);
		f.setSize(700,700);  
		f.setLocation(200,200);  
		f.setVisible(true);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x: "+e.getX());
		System.out.println("y: "+e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}  


}