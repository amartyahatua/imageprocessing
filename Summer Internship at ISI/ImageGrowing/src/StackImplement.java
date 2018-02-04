import java.awt.Point;
import java.io.*;
import java.util.*;

public class StackImplement

{
	
	public static void main(String args[]) throws IOException
	{
		Stack<Point> stack;
		String str;
		int num, n;
		stack = new Stack<Point>();
		stack.add(new Point(200,300));
		stack.add(new Point(201,301));
		stack.add(new Point(202,302));
		stack.add(new Point(203,303));
		stack.add(new Point(204,304));
		stack.add(new Point(205,305));
		stack.add(new Point(206,306));
		stack.add(new Point(207,307));
		
		
		
		
		
		
		System.out.print("Retrieved elements from the stack : \n");
		while (!stack.empty())
		{
			Point thisPoint = stack.get(0); 
			stack.remove(0);
			System.out.println(thisPoint.x);
			System.out.println(thisPoint.y);
		}		
	}


}