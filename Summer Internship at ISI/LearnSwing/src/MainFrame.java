import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame
{
	
	private DetailsPanel detailsPanel;
	
	
	public MainFrame(String title) throws IOException
	{
		super(title);
		
		// Set Layout manager
		setLayout(new BorderLayout());
		
		//Create swing comp
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("Click me: ");
		
		detailsPanel = new DetailsPanel();
		
		
		
		//Add swing comp to pane
		
		Container c = getContentPane();
		//c.add(textArea,BorderLayout.CENTER);
		//c.add(button,BorderLayout.SOUTH);
		c.add(detailsPanel,BorderLayout.WEST);
		//c.add(detailsPanel,BorderLayout.SOUTH);
		//c.add(detailsPanel,BorderLayout.NORTH);
		//c.add(detailsPanel,BorderLayout.EAST);
		
		//Add behavior
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String x = abc.abc1();
				textArea.append(x+"\n");
				
			}
		});
	}
	
	public static class abc
	{
		public static   String abc1()
		{
			String x = "abc" ;
			return x;
		}
	}
}
