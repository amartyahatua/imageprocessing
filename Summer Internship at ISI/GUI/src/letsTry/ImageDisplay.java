package letsTry;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class Display extends JFrame {

    private MyImagePanel canvas;
    private JButton okbutton;
    private JTextArea result;
    private JFileChooser filechooser;
    private static Insets insets = new Insets(0, 0, 0, 0);

    public Display(String name) {
        super(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        addWidgets();
        showGUI();
    }

    private void showGUI() {
        this.pack();
        this.setVisible(true);
    }

    private void addWidgets() {
        canvas = new MyImagePanel();
        okbutton = new JButton("OK");
        filechooser = new JFileChooser("Select imagefile");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Images", "jpg", "JPG", "GIF", "gif", "JPEG", "png", "PNG");
        filechooser.setFileFilter(filter);
        filechooser.setControlButtonsAreShown(false);
        result = new JTextArea(10, 10);
        addComponent(filechooser, 0, 0, 2, 4, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(canvas, 2, 0, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(result, 2, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(okbutton, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
    }

    public void addOKButtonListener(ActionListener okl) {
        okbutton.addActionListener(okl);
    }

    public void displayResult(String msg) {
        result.setText(msg);
    }

    public void clearResultField() {
        result.setText("");
    }

    public void displayImage(String imagefilename) {
        canvas.setImage(imagefilename);
    }

    public String getSelectedFile() {
        java.io.File selectedFile = filechooser.getSelectedFile();
        String filePathName = "";
        if (selectedFile == null) {
            result.setText("select a file");
        } else {
            filePathName = selectedFile.getPath();
        }
        return filePathName;
    }

    public void addComponent(Component component, int gridx, int gridy,
        int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
            gridwidth, gridheight, 1.0, 1.0, anchor, fill, insets, 0, 0);
        this.add(component, gbc);
    }
}//end class Display

class MyImagePanel extends JPanel {

    private BufferedImage bi;

    public MyImagePanel() {
        super();
        bi = null;
    }

    public void setImage(String imagefilename) {
        try {
            bi = ImageIO.read(new File(imagefilename));
            this.setPreferredSize(new Dimension(bi.getWidth(), bi.getHeight()));
        } catch (Exception e) {
            bi = null;
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // clear the background
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        if (bi != null) {
            // draw the image
            g.drawImage(bi, 0, 0, null);
        }
    }
}

class GUIController {

    private Display display;

    public GUIController(Display d) {
        display = d;
        display.addOKButtonListener(new OKButtonListener());
    }

    class OKButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            display.clearResultField();//make result field blank
            String fileselection = display.getSelectedFile();
            if (fileselection.length() > 0) {
                display.displayImage(fileselection);
            } else {
                display.displayResult("actionPerformed:no file selected");
                display.displayImage("");
            }
        }
    }
}

public class ImageDisplay {

    public static void main(String[] args) {
        Display d = new Display("image demo");
        GUIController ctrl = new GUIController(d);
    }
}
