import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class App implements MouseListener 
{
	 public static int x=0;
	 public static int y=0;
	 public static int clickCount=0;
	 public static Stack<Point> storeCoordinates= new Stack<Point>();
	public static void main(String args [])
	{
		
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() 
			{
				App ap =new App();
				JFrame frame = new MainFrame("TITEL");
				frame.setSize(700,700);  
				frame.setLocation(200,200);
				frame.addMouseListener(ap);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				frame.setVisible(true);
				
			}
			
			
			
		});
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("x: "+arg0.getX());
		System.out.println("y: "+arg0.getY());
		CoordinateValues coordi = new CoordinateValues();
		x=arg0.getX();
		y=arg0.getY();
		//= new Stack<Point>();
		storeCoordinates.add(new Point(x,y));
		
	
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public Stack<Point> sendStack()
	{
		return storeCoordinates;
		
	}

}
