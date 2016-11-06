
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

/**IceCreamManager implements buttons and GUI for IceCreamLine**/
public class IceCreamLineManager extends JPanel implements ActionListener {

	//new JFrame
	JFrame frame = new JFrame();
	//new instance of IceCreamLine
	IceCreamLine line = new IceCreamLine();

	/**constructor**/
	public IceCreamLineManager() {
		super();
		createGUI();		
	}

	/**creates buttons and adds them to JPanel**/
	public JPanel createButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,1));
		//creating add random order button
		JButton addOrder = new JButton("Add a random order");
		//adding actionlistener
		addOrder.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//call a random cone
						line.randomQueue();
					}
				});

		buttonPanel.add(addOrder);


		//creating serve order button
		JButton serveOrder = new JButton("Serve the next order");
		serveOrder.addActionListener(
				new ActionListener()  
				{
					public void actionPerformed( ActionEvent e )
					{
						//serving the order
						line.serveOrder();
					}
				});

		//adding button to panel
		buttonPanel.add(serveOrder);
		return buttonPanel;

	}

	/**adds buttons and IceCreamCone to BorderLayout**/
	private void createGUI()
	{
		//setting BorderLayout
		this.setLayout(new BorderLayout());
		//adding IceCreamLine to the center
		this.add(line, BorderLayout.CENTER);
		//adding buttons on top
		add(createButtons(), BorderLayout.NORTH);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
