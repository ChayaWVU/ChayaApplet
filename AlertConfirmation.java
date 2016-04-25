import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AlertConfirmation {

	protected JFrame frame;
	protected JButton homeButton;

	/**
	 * Create the application.
	 */
	public AlertConfirmation() {
		frame = new JFrame();
		homeButton = new JButton("Home");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		JLabel lblAlertSentTo = new JLabel("Alert Sent");
		lblAlertSentTo.setForeground(Color.RED);
		lblAlertSentTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertSentTo.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblAlertSentTo.setBounds(35, 1, 250, 100);
		this.frame.getContentPane().add(lblAlertSentTo);
		
		this.homeButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.homeButton.setBounds(0, 125, 315, 110);
		this.frame.getContentPane().add(homeButton);
	}
}
