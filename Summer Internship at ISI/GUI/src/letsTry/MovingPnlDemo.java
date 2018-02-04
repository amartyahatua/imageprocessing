package letsTry;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MovingPnlDemo extends JFrame
implements ActionListener, MouseListener, MouseMotionListener
{
	private JPanel contentPane;
	private JPanel panel;
	private javax.swing.Timer timer;
	private int xPos, yPos;
	public MovingPnlDemo()
	{
		timer = new javax.swing.Timer(10,this);
		contentPane = new JPanel();
		contentPane = (JPanel) this.getContentPane();
		contentPane.setBackground(Color.BLUE);
		panel = new JPanel();
		panel.setOpaque(true);
		panel.setSize(100, 100);
		panel.setVisible(true);
		panel.setLayout(null);
		panel.addMouseMotionListener(this);
		addComponent(contentPane, panel, 40, 40, 100, 100);
		setTitle("Java Tutorial - Moving JPanels");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void addComponent(Container container,
			Component c, int x, int y, int w, int h)
	{
		c.setBounds(x,y,w,h);
		container.add(c);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == timer)
		{
			addComponent(contentPane, panel, xPos, yPos, 200, 200);
		}
	}
	public void mouseDragged(MouseEvent evt)
	{
		timer.start();
		xPos = evt.getXOnScreen() - getX() - 100;
		yPos = evt.getYOnScreen() - getY() - 40;
	}
	@Override
	public void mouseMoved(MouseEvent evt){}
	public void mouseClicked(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
	public void mousePressed(MouseEvent evt){}
	public void mouseReleased(MouseEvent evt){}
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.err.println("Could not set Look And Feel");
		}
		new MovingPnlDemo();
	}
}