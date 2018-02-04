import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.applet.Applet;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class amartya extends Applet {
    JComboBox combobox_1;
    JButton button_1;
    JButton button_2;
    JButton button_3;
    JTextField textfield_1;

    public void init() {
        amartyaLayout customLayout = new amartyaLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        combobox_1 = new JComboBox();
        combobox_1.addItem("item1");
        combobox_1.addItem("item2");
        add(combobox_1);

        button_1 = new JButton("button_1");
        add(button_1);

        button_2 = new JButton("button_2");
        add(button_2);

        button_3 = new JButton("button_3");
        add(button_3);

        textfield_1 = new JTextField("textfield_1");
        add(textfield_1);

        setSize(getPreferredSize());

    }

    public static void main(String args[]) {
        amartya applet = new amartya();
        Frame window = new Frame("amartya");

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        applet.init();
        window.add("Center", applet);
        window.pack();
        window.setVisible(true);
    }
}

class amartyaLayout implements LayoutManager {

    public amartyaLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 720 + insets.left + insets.right;
        dim.height = 673 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+275,insets.top+461,98,40);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+275,insets.top+576,98,40);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+141,insets.top+461,98,40);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+410,insets.top+461,98,40);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+275,insets.top+518,98,40);}
    }
    
    
    public void paint(Graphics g)
	{
		
    	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();

    	File file = new File("C:/Documents and Settings/Administrator/Desktop/out.bmp");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	g.drawImage(image,0,0,(dim.width/3),(dim.height/3), null);  	
	}
  
    
}
