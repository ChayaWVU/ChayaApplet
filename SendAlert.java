import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class SendAlert {

	protected JFrame frame;
	protected JButton sendAlertButton;
	protected JButton backButton;

	/**
	 * Create the application.
	 */
	public SendAlert() {
		frame = new JFrame();
		sendAlertButton = new JButton("Send Alert");
		backButton = new JButton("Home");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		this.sendAlertButton.setForeground(Color.BLACK);
		this.sendAlertButton.setBackground(Color.RED);
		this.sendAlertButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		this.sendAlertButton.setBounds(0,0, 325, 125);
		this.frame.getContentPane().add(sendAlertButton);
		
		this.backButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		this.backButton.setBounds(0, 125, 325, 110);
		this.frame.getContentPane().add(backButton);
	}

}
