import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame  
{
	private DetailsPanel detailsPanel;
	
	public MainFrame(String title )
	{
		super(title);
		
		
		// Set layout manager 
		setLayout(new BorderLayout()); 
		
		
		
		//Create swing components 
		
		JTextArea textArea = new JTextArea();
		JButton btn = new JButton("Perform");
		
		
		//Add swing component to content pane
		
		detailsPanel = new DetailsPanel();
		
		
	
		
		Container c = getContentPane();
		c.add(textArea,BorderLayout.CENTER);
		c.add(btn,BorderLayout.SOUTH);
		c.add(detailsPanel, BorderLayout.WEST);
		
		
		//Add behaviour 
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//detailsPanel = new DetailsPanel("C:/Documents and Settings/Administrator/Desktop/src.jpg");
				
				
			}
		});
		
		
		
		
		
		
	}
}
