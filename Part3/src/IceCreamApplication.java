import java.awt.Graphics;

import javax.swing.JFrame;

/**implements IceCreamShop**/
public class IceCreamApplication {
	
	public static void main(String[] args)
	{
		//new frame
		JFrame iceCreamFrame = new JFrame("Ice Cream Shop");
		//setting dimensions
		iceCreamFrame.setSize(800, 1000);
		//creating new IceCreamShop
		iceCreamFrame.add(new IceCreamShop());
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iceCreamFrame.setVisible(true);
		iceCreamFrame.setFocusable(true);
	}
}
