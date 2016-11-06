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
	StackLL<String> imp = new StackLL<String>();

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
		//System.out.println("queue peek -"+orders.peek());
		validate();
		repaint();
	}

	/**get the stack of flavors in the top IceCreamCone in queue**/
	public StackLL<String> getTop() {
		//if order queue is not null
		if (orders.peek().getStack() != null) {
			//get the stack of flavors on top
			return orders.peek().getStack();
		}
		return null;
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


