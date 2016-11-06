import java.awt.Graphics;

import javax.swing.JFrame;

/**application to run IceCreamLineManager**/
public class IceCreamApplication {
	
	public static void main(String[] args)
	{
		//new Frame
		JFrame iceCreamFrame = new JFrame("Ice Cream Line");
		//setting dimensions
		iceCreamFrame.setSize(600, 400);
		//calling new IceCreamLineManager
		iceCreamFrame.add(new IceCreamLineManager());
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iceCreamFrame.setVisible(true);
		iceCreamFrame.setFocusable(true);
	}
}
