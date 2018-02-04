import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DetailsPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2618720479051619093L;
	static String path="";
	public void getImage(String ab)
	{
		path=ab;
		//System.out.println(path);
	}
	
	
	public DetailsPanel()
	{
		
		
		path = "C:/Documents and Settings/Administrator/Desktop/test/src.jpg";
		
		ImageIcon img = new ImageIcon(path);
		
		Dimension size = getPreferredSize();
		size.width=600;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Image"));
		
		JLabel inputImage = new JLabel(img);
		JLabel outputImage = new JLabel(img);
		
		JButton btn2 =new JButton("Select");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		
		///// First column 
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx=0.5;
		gc.weighty=0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(inputImage,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		
		add(outputImage,gc);
		
		gc.weighty=10;
		
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.gridx = 0;
		gc.gridy = 3;
		add(btn2,gc);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				App  ep = new App();
				
				Stack<Point> abc = ep.sendStack();
				Caller clr = new Caller();
				
				while(abc.size()>0)
				{
					Point thisPointGreen = abc.get(0); 
					abc.remove(0);			
					clr.getPerformed(thisPointGreen.x,thisPointGreen.y,path,13);
				}
			}
		});
		
		
	}
}
