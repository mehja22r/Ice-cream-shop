import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.Box;

/**IceCreamLine creates a queue to IceCreamCones**/
public class IceCreamLine extends JPanel {

	/**queue to type IceCreamCone**/
	QueueLL<IceCreamCone> orders = new QueueLL<IceCreamCone>();

	/**constructor**/
	public IceCreamLine() {
		super();
		//setting it to box layout to display vertical cones
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	/**generate randome IceCreamCones and store them in a queue**/
	public void randomQueue() {
		//creating an instance of IceCreamCone
		IceCreamCone cone = new IceCreamCone();
		//generate random flavors
		cone.addScoop(cone.randomNumberOfScoops());
		//enqueue cone in queue
		orders.enqueue(cone);
		//add cone to box
		this.add(cone);
		validate();
		repaint();

	}

	/**serve order makes the cone disappear**/
	public void serveOrder() {
		//if the queue is not empty
		if (!orders.isEmpty()) {
			//dequeue it
			this.remove(orders.dequeue());
		}
		revalidate();
		repaint();
	}
}


