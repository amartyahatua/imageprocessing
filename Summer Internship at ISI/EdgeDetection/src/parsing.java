
public class parsing 
{
	public static void main(String args[])
	{
		String employee = "C:/Documents and Settings/Administrator/workspace/EdgeDetection/abc.jpg";
		String delims = "[.]";
		String[] tokens = employee.split(delims);
		
		for(int i=0;i<tokens.length;i++)
			System.out.println(tokens[i]);
	}
}
