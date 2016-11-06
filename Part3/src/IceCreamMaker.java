import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






// swing 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**IceCreamMaker implements buttons and GUI for IceCreamCone**/
public class IceCreamMaker extends JPanel{

	/**a new instance of IceCreamCone**/
	IceCreamCone cone = new IceCreamCone();

	/**constructor**/
	public IceCreamMaker() {
		super();
		// call instance method to initialize the graphics
		createGUI();
	}

	/**private method to create the GUI components**/
	private void createGUI()
	{
		// use a border layout
		setLayout( new BorderLayout() );

		//adding buttons on top
		add(createButtons(), BorderLayout.NORTH);

		// then, create panel for drawing the ice cream cone
		// and add to center
		add(  cone, BorderLayout.CENTER );

	}

	/**method creats buttons and adds them to a JPanel and returns them**/
	public JPanel createButtons() {

		//a new JPanel
		JPanel buttonPanel = new JPanel();
		//setting GridLayout
		buttonPanel.setLayout(new GridLayout(0, 4));

		//creating vanilla button and coloring it
		JButton vanilla = new JButton("vanilla");
		vanilla.setBackground(Color.WHITE);
		vanilla.setBorderPainted(false);
		vanilla.setContentAreaFilled(false);
		vanilla.setOpaque(true);
		//adding action lisetenr to vanilla
		vanilla.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//push vanilla into stack when clicked
						cone.addScoop("vanilla");
						repaint();
					}
				});
		//creating strawberry button and coloring it pink
		JButton strawberry =  new JButton("strawberry");
		strawberry.setBackground(Color.PINK);
		strawberry.setContentAreaFilled(false);
		strawberry.setOpaque(true);
		strawberry.setBorderPainted(false);
		strawberry.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//pushing straberry into stack when clicked
						cone.addScoop("strawberry");
						repaint();
					}
				});

		//creating Green tea button
		JButton greenTea =  new JButton("green tea");
		greenTea.setBackground(Color.GREEN);
		greenTea.setBorderPainted(false);
		greenTea.setOpaque(true);
		greenTea.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//push greenTea into stack
						cone.addScoop("greenTea");
						repaint();
					}
				});
		//creating burnt caramel button
		JButton burntCaramel = new JButton("burnt caramel");
		burntCaramel.setBackground(Color.YELLOW);
		burntCaramel.setBorderPainted(false);
		burntCaramel.setOpaque(true);
		burntCaramel.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//push burnt caramel into stack 
						cone.addScoop("burntCaramel");
						repaint();
					}
				});

		//create button to remove top scoops
		JButton remove = new JButton("Trash the top scoop!");
		//a new JPanel 
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(2,1)); 
		remove.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//trash scoop when called
						cone.trashScoop();
						repaint();
					}
				});

		//adding buttons to button panel
		buttonPanel.add(vanilla);
		buttonPanel.add(strawberry);
		buttonPanel.add(greenTea);
		buttonPanel.add(burntCaramel);
		//adding buttonPanel to new panel
		newPanel.add(buttonPanel);	
		newPanel.add(remove);

		//return the newPanel
		return newPanel;
	}

	/**delete all servings of scoops**/
	public void serveScoop() {
		//while flavors is not empty
		while (cone.flavors.isEmpty() == false) {
			//pop all the flavors
			cone.flavors.pop();
		}	
	}
}
