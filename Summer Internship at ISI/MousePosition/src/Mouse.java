import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class Mouse extends MouseAdapter{
	public static void main(String[] args) throws InterruptedException{
		while(true){
			Thread.sleep(100);
			//MouseEvent me = null;
			//me.
	
			System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "+MouseInfo.getPointerInfo().getLocation().y+")");
		}
	}
}