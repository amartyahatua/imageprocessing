import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;


public class DrowLine {
	public static void main(String[] args) {
		System.out.println("Line draw example using java Swing");
		JFrame frame = new JFrame("Draw line example");
		BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.BLACK);
		RoundRectangle2D round = new RoundRectangle2D.Double(50, 50, 100, 100, 50, 50);
		g.draw(round);
		Point2D mousePoint = new Point2D.Double(101, 101);
		Point2D center = new Point2D.Double(round.getCenterX(), round.getCenterY());
		Point2D point2 = new Point2D.Double();
		if (center.getX() == mousePoint.getX())
			point2.setLocation(mousePoint.getX(), (mousePoint.getY() < center.getY()) ? round.getMinY() : round.getMaxY());
		else {
			double a = (center.getY() - mousePoint.getY()) / (center.getX() - mousePoint.getX());
			double b = mousePoint.getY() - a * mousePoint.getX();
			double x = (mousePoint.getX() < center.getX()) ? round.getMinX() : round.getMaxX();
			point2.setLocation(x, a * x + b);
		}
		Line2D line = new Line2D.Double(mousePoint, point2);
		g.setClip(round);
		g.draw(line);
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}