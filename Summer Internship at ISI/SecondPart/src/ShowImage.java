
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.*;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
public class ShowImage extends JFrame implements ActionListener,MouseInputListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static BufferedImage image1,image2;
	static int flag = 0;
	static JFrame frame;
	static Panel panel ,panel1;
	static JComboBox combo ;
	static JTextField text;
	static JTextArea area;
	static File file = null;
	static String path=null;
	static JButton selectBtn, prfmBtn, browseBtn;
	static Container cont;
	static int select=0;
	public static Stack<Point> storeCoordinates= new Stack<Point>();
	static int xCoordinate =0;
	static int yCoordinate =0;
	static String threshold =null;
	static int noOfClick =0;
	static JPopupMenu Pmenu;
	static JMenuItem menuItem;
	static String getOutputImage=null;
	

	ShowImage()
	{
		frame = this;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Display Image");


		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		

		panel = new Panel();
		panel1 = new Panel();
		area= new JTextArea();
		area.setColumns(120);
		selectBtn = new JButton("select"); 
		prfmBtn = new JButton("Perform");
		browseBtn = new JButton("Browse");
		text = new JTextField(20);
		String course[] = {"","Image thresholding","Region growing",""};
		combo = new JComboBox(course);
		combo.setBackground(Color.gray);
		combo.setForeground(Color.red);
		//JLabel label2=new JLabel("Customer Name :Mahmoud Saleh       "+xCoordinate+"               ",JLabel.RIGHT);
		


		
		cont.add(panel,BorderLayout.EAST);
		panel.add(selectBtn);
		panel.add(prfmBtn);
		panel.add(browseBtn);
		panel.add(combo);
		panel.add(text);
		panel.add(area);
		frame.addMouseListener((MouseListener) frame);

		cont.add(panel,BorderLayout.SOUTH);
		//panel1.add(label2);
		cont.add(panel1,BorderLayout.EAST);

		browseBtn.addActionListener(this);
		prfmBtn.addActionListener(this);
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
		int height=0;
		int width=0;

		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();

		if(image1!=null)
		{
			height = image1.getHeight();
			width = image1.getWidth();
		}

		if (flag==0)

			g.drawImage(image1,4,36,width,height, null);
		else{
			g.drawImage(image1,4,36,width,height, null);
			File input = new File(getOutputImage);
			try {
				image2 = ImageIO.read(input);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	

			g.drawImage(image2,(10+width),36,width,height, null);	
			//g.drawImage(image,((2*dim.width)/3),0,width,height, null);	
			flag=0;

		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("This"+e.getID()+" "+e.getActionCommand());
		if(e.getSource()== browseBtn)
		{

			JFileChooser chooser = new JFileChooser();
			/*chooser.showOpenDialog(null);*/
			int returnVal = chooser.showOpenDialog(null);

			if(returnVal == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				path=file.getPath();

				File input = new File(path);
				try {
					image1 = ImageIO.read(input);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				frame.repaint();
				frame.validate();
			}
		}

		else
			if(e.getSource()==prfmBtn)
			{
				Caller clr = new Caller();
				//
				threshold=text.getText();
				String[] results = threshold.split(","); 
				int threshold[] = new int [300];

				for(int i =0;i<results.length;i++)
				{
					String temp=results[i];
					threshold[i]=Integer.parseInt(temp);
				}		
				 getOutputImage=clr.getPerformed(path, storeCoordinates,select,threshold);
			}
			else
				if(e.getSource()==selectBtn)
				{

					flag=1;
					frame.repaint();
					frame.validate();

				}

				else
					if(e.getSource()==combo)
					{
						select =combo.getSelectedIndex();
						System.out.println("Select "+select);
						System.out.println(combo.getSelectedIndex());
					}



	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(arg0.getX());
		System.out.println(arg0.getY());
		xCoordinate=arg0.getX();
		yCoordinate=arg0.getY();
		storeCoordinates.add(new Point(xCoordinate,yCoordinate));
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}


