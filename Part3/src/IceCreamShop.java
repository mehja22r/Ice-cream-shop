import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**IceCreamShop implements IceCreamShop**/
public class IceCreamShop extends JPanel implements ActionListener{

	/**creating an instance of IceCreamMaker**/
	IceCreamMaker maker = new IceCreamMaker();
	/**creating instance of IceCreamLineManager**/
	IceCreamLineManager manager = new IceCreamLineManager();
	JLabel heading;
	int score = 0;

	/**constructor**/
	public IceCreamShop() {
		super();
		createGUI();
		//getImp();
	}

	/**method creates buttons and IceCreamCones**/
	private void createGUI()
	{
		// use a border layout
		setLayout( new BorderLayout() );

		//adding buttons and text on top
		add(createButtons(), BorderLayout.NORTH);

		//adding maker and manager GUI components
		add(maker, BorderLayout.CENTER);
		add(manager, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**create intro text and score label**/
	public JPanel createButtons() {
		//new JPanel
		JPanel mainButtonPanel = new JPanel();
		//new JLabel
		heading = new JLabel ("<html>Make ice cream cones to match the next order at the top " +"<br>"
				+"Every correct order served earnes you 10 points" + "<br>" +"Make the wrong cone and you'll lose 5 points<br>Score : "+score+"</html>");
		mainButtonPanel.setLayout(new GridLayout(0,1));
		//creating serveOrder method
		JButton serveOrder = new JButton("Serve next order");
		serveOrder.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//remove scoops
						serveScoop();
						repaint();
					}
				});

		//adding buttons and heading
		mainButtonPanel.add(heading);
		mainButtonPanel.add(serveOrder);


		return mainButtonPanel;
	}

	/**method to remove icecream in the queue and scoops in the maker**/
	public void serveScoop() {
		score  += score();
		heading.setText("<html>Make ice cream cones to match the next order at the top " +"<br>"
				+"Every correct order served earnes you 10 points" + "<br>" +"Make the wrong cone and you'll lose 5 points<br>Score : "+score+"</html>");
	}

	/**calculates score**/
	public int score() {
		//makerFlavor stores stack of flavors user puts on the cone
		StackLL<String> makerFlavors = maker.cone.getStack();
		//lineFlavors stores stack of flavors in the queue
		StackLL<String> lineFlavors = new StackLL<String>();
		//if there is a cone in queue
		if (manager.line.orders.peek() != null) {
			//get the top stack of flavors in the queue
			lineFlavors = manager.line.getTop();
		}
		//local var score will be zero
		int score = 0;
		//if there is nothing in the queue
		if (lineFlavors.isEmpty() == true) {
			//score will not change
			score=score;
			return score;
		}
		//if user creates an icecream cone and there is something in the queue
		while(!makerFlavors.isEmpty() && !lineFlavors.isEmpty()) {
			//if makerFlavors and lineFlavors are not equal
			if (!makerFlavors.pop().equals(lineFlavors.pop())) {
				//pop them
				maker.serveScoop();
				manager.line.serveOrder();
				//score is -5 and return -5
				score = -5;
				return score;
			}

		} 
		//if makerFlavors is not empty and queue is not empty
		if (!makerFlavors.isEmpty() || !lineFlavors.isEmpty()) {
			//score is -5
			score = -5;
		}
		//if they match
		else {
			//score will increase
			score = 10;
		}
		//pop the queue top stack and makerFlavors
		maker.serveScoop();
		manager.line.serveOrder();
		return score;
	}

}
