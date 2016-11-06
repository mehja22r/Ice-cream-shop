import java.awt.Graphics;

import javax.swing.JFrame;

/**IceCreamApplication runs Part1**/
public class IceCreamApplication {
	
	public static void main(String[] args)
	{
		//creating a new JFrame
		JFrame iceCreamFrame = new JFrame("Ice Cream Maker");
		
		//setting size of window
		iceCreamFrame.setSize(600, 400);
		
		//calling an instance of IceCreamMaker
		iceCreamFrame.add(new IceCreamMaker());
		
		iceCreamFrame.setVisible(true);
		iceCreamFrame.setFocusable(true);
	}
}
