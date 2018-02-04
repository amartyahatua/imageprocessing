package letsTry;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.applet.Applet;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class gui extends Applet {
	JButton button_1;
	JTextArea textarea_1;
	JScrollPane sp_textarea_1;
	JButton button_2;
	JComboBox combobox_1;
	JButton button_3;
	JTextField textfield_2;

	public void init() {
		guiLayout customLayout = new guiLayout();

		setFont(new Font("Helvetica", Font.PLAIN, 12));
		setLayout(customLayout);

		button_1 = new JButton("Do");
		add(button_1);

		textarea_1 = new JTextArea("");
		sp_textarea_1 = new JScrollPane(textarea_1);
		add(sp_textarea_1);

		button_2 = new JButton("Save");

		add(button_2);

		combobox_1 = new JComboBox();
		combobox_1.addItem("item1");
		combobox_1.addItem("item2");
		add(combobox_1);

		button_3 = new JButton("Browse");
		add(button_3);

		textfield_2 = new JTextField();
		add(textfield_2);

		button_3.addActionListener(null);
		//window=this;
		

		setSize(getPreferredSize());

	}

	public static void main(String args[]) 
	{
		gui applet = new gui();
		JFrame window = new JFrame("gui");

		window.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
		



		applet.init();
		window.add("Center", applet);
		window.pack();
		window.setVisible(true);
	}


	public void paint(Graphics g)
	{
		super.paint(g);

		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();

		/*File file = new File("C:/Documents and Settings/Administrator/Desktop/test/lena.bmp");
		BufferedImage image=null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(image,0,0,(dim.width/3),(dim.height/3), null);*/
	}



}

class guiLayout implements LayoutManager {

	public guiLayout() {
	}

	public void addLayoutComponent(String name, Component comp) {
	}

	public void removeLayoutComponent(Component comp) {
	}

	public Dimension preferredLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);

		Insets insets = parent.getInsets();
		dim.width = 641 + insets.left + insets.right;
		dim.height = 466 + insets.top + insets.bottom;

		return dim;
	}

	public Dimension minimumLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);
		return dim;
	}

	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();

		Component c;
		c = parent.getComponent(0);
		if (c.isVisible()) {c.setBounds(insets.left+282,insets.top+250,58,19);}
		c = parent.getComponent(1);
		if (c.isVisible()) {c.setBounds(insets.left+6,insets.top+326,646,147);}
		c = parent.getComponent(2);
		if (c.isVisible()) {c.setBounds(insets.left+282,insets.top+288,58,19);}
		c = parent.getComponent(3);
		if (c.isVisible()) {c.setBounds(insets.left+198,insets.top+250,58,19);}
		c = parent.getComponent(4);
		if (c.isVisible()) {c.setBounds(insets.left+122,insets.top+250,58,19);}
		c = parent.getComponent(5);
		if (c.isVisible()) {c.setBounds(insets.left+358,insets.top+250,58,19);}
	}
}


























