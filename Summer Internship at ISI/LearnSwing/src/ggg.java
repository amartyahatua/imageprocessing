import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ggg {

	public static void main(String[] args){
		JFrame frame=new JFrame();
		JButton b=new JButton("Submit");
		frame.add(b);
		frame.setVisible(true);
		frame.pack();
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JFrame f=new JFrame();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				f.setLocation((int)d.getWidth()/2 - (int)f.getPreferredSize().getWidth()/2,
						(int)d.getHeight()/2 - (int)f.getPreferredSize().getHeight()/2);
				f.setVisible(true);
				f.setSize(300,100);
			}
		});
	}
}
