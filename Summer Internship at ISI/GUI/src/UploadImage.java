

import java.sql.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

public class UploadImage extends JFrame {
	Image img;
	JTextField text=new JTextField(20);
	JButton browse,save;
	JPanel p=new JPanel(new GridLayout(1,2));
	JLabel label=new JLabel();
	File file = null;
	String path="";
	public UploadImage() {

		browse = new JButton("Upload");
		save = new JButton("Save");
		text.setBounds(20,20,140,20);
		browse.setBounds(160,20,100,20);
		label.setBounds(20,40,260,20);
		save.setBounds(250,20,100,20);
		add(p);
		setSize(600,500);
		
		add(text);
		add(browse);
		add(save);

		add(label);
		setVisible(true);

		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.addChoosableFileFilter(new ImageFileFilter());
				int returnVal = chooser.showOpenDialog(null);

				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					path=file.getPath();
					ImageIcon icon=new ImageIcon(path);
					label.setIcon(icon);
					text.setText(path);

					repaint();
				}
			}
		});
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					File f=new File(path);
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.10.13:3306/rose", "root", "root");
					PreparedStatement psmnt = connection.prepareStatement("insert into images(image) values(?)");
					FileInputStream fis = new FileInputStream(f);
					psmnt.setBinaryStream(1, (InputStream)fis, (int)(f.length()));
					int s = psmnt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Inserted successfully!");
				}
				catch(Exception ex){
					System.out.print(ex);
				}
			}

		});
	}

	public static void main(String[] args) {
		new UploadImage();
	}

}
class ImageFileFilter extends javax.swing.filechooser.FileFilter {
	public boolean accept(File file) {
		if (file.isDirectory()) return false;
		String name = file.getName().toLowerCase();
		return (name.endsWith(".jpg") || name.endsWith(".png")|| name.endsWith(".gif"));
	}
	public String getDescription() { return "Images (*.gif,*.bmp, *.jpg, *.png )"; }
}

