import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Emergency {

	protected JFrame frame;
	protected JButton yesButton;
	protected JButton noButton;
	
	/**
	 * Constructor
	 */
	public Emergency() {
		frame = new JFrame();
		yesButton = new JButton("YES");
		noButton = new JButton("NO");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		JLabel emergencyLabel = new JLabel("Emergency");
		emergencyLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		emergencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyLabel.setForeground(Color.RED);
		emergencyLabel.setBackground(new Color(255, 0, 0));
		emergencyLabel.setBounds(25, 1, 250, 100);
		this.frame.getContentPane().add(emergencyLabel);
		
		this.yesButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		this.yesButton.setBounds(5, 107, 145, 125);
		this.frame.getContentPane().add(yesButton);
		
		this.noButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		this.noButton.setBounds(165, 107, 145, 125);
		this.frame.getContentPane().add(noButton);
	}
}
