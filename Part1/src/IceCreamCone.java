import java.awt.Color;
import java.awt.Graphics;


// swing
import javax.swing.JComponent;

/**IceCreamCone draws cone and scoopes**/
public class IceCreamCone extends JComponent{

	public static final int CONE_WIDTH = 40;
	public static final int CONE_HEIGHT = 80;	
	public static final int SCOOP_DIAMETER = 50;	
	public static final int SCOOP_OVERLAP = 10;	
	public int adjustHeight = 0;

	/**stack to hold flavors to be drawn**/
	StackLL<String> flavors =  new StackLL<String>();

	String vanilla = "vanilla";
	String strawberry = "strawberry";
	String greenTea = "green tea";
	String burntCaramel = "burnt caramel";

	/**constructor**/
	public IceCreamCone() {
		super();
	}

	/**method pushes flavor into stack**/
	public void addScoop(String f) {
		flavors.push(f);
	}


	/**method adds random scoop**/
	public void addScoop() {
		//get a number between 0-3
		double randomFlavor = Math.random()*3.9;
		//turn number to an integer
		int ranFla = (int) randomFlavor;
		switch(ranFla) {
		case 0: 
			flavors.push(vanilla);
			break;
		case 1: 
			flavors.push(strawberry);
			break;
		case 2:
			flavors.push(greenTea);
			break;
		case 3:
			flavors.push(burntCaramel);
			break;
		}
	}

	/**
	 * Override the paint method to draw an ice cream cone.
	 **/
	public void paint( Graphics g )
	{
		paintCone( g );
		paintScoop( g );
	}


	/**
	 * paint the cone
	 **/
	private void paintCone( Graphics g )
	{

		//System.out.println("draw cone");
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		// center bottom point
		xPoints[0] = getWidth() / 2;
		yPoints[0] = getHeight();

		// upper left point
		xPoints[1] = xPoints[0] - (CONE_WIDTH/2);
		yPoints[1] = yPoints[0] - CONE_HEIGHT;

		// upper right point
		xPoints[2] = xPoints[0] + (CONE_WIDTH/2);
		yPoints[2] = yPoints[0] - CONE_HEIGHT;

		// set the paint color
		g.setColor( Color.YELLOW );

		// draw triangle
		g.fillPolygon( xPoints, yPoints, 3 );
	}

	/**
	 * paint the scoop
	 **/
	private void paintScoop( Graphics g)
	{	
		//temp stack to hold flavors
		StackLL<String> tempScoops = new StackLL<String>();

		//while the flavor stack is not empty
		while (flavors.peek() != null) {	
			//s will store popped flavors
			String s = flavors.pop();
			//and temp stack will push it
			tempScoops.push(s);
		}

		//while temp stack is not null
		while (tempScoops.peek() != null) {
			//if the flavor pushed was vanilla
			if (tempScoops.peek()=="vanilla") {			
				g.setColor(Color.WHITE);
				// fill oval (upper left x, upper left y, width, height)
				g.fillOval( 
						// upper left x is center minus half diameter
						getWidth()/2 - SCOOP_DIAMETER/2,
						// upper left y accounts for cone height and a bit of overlap
						getHeight() - CONE_HEIGHT - SCOOP_DIAMETER - adjustHeight + SCOOP_OVERLAP,
						SCOOP_DIAMETER, SCOOP_DIAMETER );
				adjustHeight += SCOOP_DIAMETER;
				//push the flavor back into the flavor stack
				flavors.push(tempScoops.pop());
			}

			//if flavor was strawberry
			else if (tempScoops.peek()=="strawberry") {
				g.setColor(Color.PINK);
				// fill oval (upper left x, upper left y, width, height)
				g.fillOval( 
						// upper left x is center minus half diameter
						getWidth()/2 - SCOOP_DIAMETER/2,
						// upper left y accounts for cone height and a bit of overlap
						getHeight() - CONE_HEIGHT - adjustHeight - SCOOP_DIAMETER + SCOOP_OVERLAP,
						SCOOP_DIAMETER, SCOOP_DIAMETER );
				adjustHeight += SCOOP_DIAMETER;
				//push starwberry back into flavor stack
				flavors.push(tempScoops.pop());
			}
			//if the flavor was greenTea
			else if (tempScoops.peek()=="greenTea") {
				g.setColor(Color.GREEN);
				// fill oval (upper left x, upper left y, width, height)
				g.fillOval( 
						// upper left x is center minus half diameter
						getWidth()/2 - SCOOP_DIAMETER/2,
						// upper left y accounts for cone height and a bit of overlap
						getHeight() - CONE_HEIGHT - adjustHeight - SCOOP_DIAMETER + SCOOP_OVERLAP,
						SCOOP_DIAMETER, SCOOP_DIAMETER );
				adjustHeight += SCOOP_DIAMETER;
				//push flavor back into stack
				flavors.push(tempScoops.pop());

			}
			//if flavor was burntCaramel
			else if (tempScoops.peek()=="burntCaramel") {
				g.setColor(Color.ORANGE);
				// fill oval (upper left x, upper left y, width, height)
				g.fillOval( 
						// upper left x is center minus half diameter
						getWidth()/2 - SCOOP_DIAMETER/2,
						// upper left y accounts for cone height and a bit of overlap
						getHeight() - CONE_HEIGHT - adjustHeight - SCOOP_DIAMETER + SCOOP_OVERLAP,
						SCOOP_DIAMETER, SCOOP_DIAMETER );
				adjustHeight += SCOOP_DIAMETER;
				//push flavor back into stack
				flavors.push(tempScoops.pop());
			}
		}
		//reset adjust height back to 0 as the series of scoops have been drawn
		adjustHeight = 0;
	}

	/**get rid of the top scoop by popping the the stack**/
	public void trashScoop() {
		flavors.pop();
	}
}
