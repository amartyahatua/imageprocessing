package letsTry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class ShowImage extends JFrame implements ActionListener{
	static BufferedImage image;
	static int flag = 0;
	static JFrame frame;
	static Panel panel ;
	static JComboBox combo ;
	static JTextField text;
	static File file = null;
	static String path=null;
	static JButton selectBtn, resetBtn, browseBtn;
	static Container cont;

	ShowImage()
	{
		frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Display Image");
        
		
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());

		panel = new Panel();
		selectBtn = new JButton("select"); 
		resetBtn = new JButton("reset");
		browseBtn = new JButton("Browse");
		text = new JTextField(20);


		String course[] = {"BCA","MCA","PPC","CIC"};
		combo = new JComboBox(course);
		combo.setBackground(Color.gray);
		combo.setForeground(Color.red);

		panel.add(selectBtn);
		panel.add(resetBtn);
		panel.add(browseBtn);
		panel.add(combo);
		panel.add(text);
		
		cont.add(panel,BorderLayout.SOUTH);

		browseBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		combo.addActionListener(this);
		selectBtn.addActionListener(this);

		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
        frame.setMinimumSize(dim);
        
		pack();
		setVisible(true);

	}

	static public void main(String args[]) throws Exception 
	{
		ShowImage showImage = new ShowImage();

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		if (flag==0)
			g.drawImage(image,0,0,(dim.width/3),(dim.height/3), null);
		else{
			g.drawImage(image,0,0,(dim.width/3),(dim.height/3), null);
			g.drawImage(image,200,30,(dim.width/3),(dim.height/3), null);	
			g.drawImage(image,600,100,(dim.width/3),(dim.height/3), null);	
		}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("This"+e.getID()+" "+e.getActionCommand());
		if(e.getSource()== browseBtn)
		{
			JFileChooser chooser = new JFileChooser();
			
			int returnVal = chooser.showOpenDialog(null);

			if(returnVal == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				path=file.getPath();

				File input = new File(path);
				try {
					image = ImageIO.read(input);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				frame.repaint();
				frame.validate();
			}
		}
		else
		if(e.getSource()==resetBtn)
		{
			
		}
		else
		if(e.getSource()==selectBtn)
		{
			flag=1;
			frame.repaint();
			frame.validate();

		}
		

	}
}


