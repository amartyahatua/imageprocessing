import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DetailsPanel extends JPanel 
{
	public DetailsPanel()
	{
		Dimension size = getPreferredSize();
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
				
		size.width=50;
		size.height=50;

		
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Image"));
		
		ImageIcon image = new ImageIcon( "C:/Documents and Settings/Administrator/Desktop/ah/eye.jpg" );
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		JLabel label = new JLabel();
		
		
		//this.getRootPane().add(panel);

		//setVisible(true); 
		
		
		
		
		
		
		
		JLabel nameLabel = new JLabel("Name:  ");
		JLabel occupationLabel = new JLabel("Occupation: ");
		JLabel imageDisplay = new JLabel(image);
		imageDisplay.setIcon(image);
		panel.setBackground(Color.BLUE);
		panel.add(imageDisplay);
		
		
		final JTextField nameField = new JTextField(10);
		final JTextField occupationField = new JTextField(10);
		
		JButton addBtn = new JButton("Add");
		JButton addBtn1 = new JButton("Add1");
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		/////////////   First column //////////
		gc.weightx =0.5;
		gc.weighty =0.5;
		
		/*gc.gridx = 0;
		gc.gridy = 0;
		
		add(nameLabel,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		
		add(occupationLabel,gc);
		
		gc.gridx =1;
		gc.gridy =0;
		add(nameField,gc);
		
		gc.gridx=1;
		gc.gridy=1;
		add(occupationField,gc);
		
		gc.weighty=1;*/
		
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(imageDisplay,gc);
		
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(addBtn,gc);
		
		
		
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 0;
		add(addBtn1,gc);
		
	}
}
