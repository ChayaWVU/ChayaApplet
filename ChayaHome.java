import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.firebase.client.Firebase;

public class ChayaHome {

	boolean flag;
	protected JFrame frame;
	protected JButton emergencyButton;
	protected JButton medSchedButton;
	protected JLabel heartRate;
	Firebase ref = new Firebase("https://amber-heat-6570.firebaseIO.com");
	/**
	 * Constructor
	 */
	public ChayaHome() {
		frame = new JFrame();
		emergencyButton = new JButton("Emergency");
		medSchedButton = new JButton("Schedule");
		heartRate = new JLabel("0");
	}


	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize(boolean setter) {
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.emergencyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.emergencyButton.setBounds(2, 107, 145, 125);
		this.frame.getContentPane().add(emergencyButton);
		this.medSchedButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.medSchedButton.setBounds(162, 107, 145, 125);
		this.frame.getContentPane().add(this.medSchedButton);
		
		//changeHR section of code
		this.heartRate.setHorizontalAlignment(SwingConstants.LEFT);
		this.heartRate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.heartRate.setBounds(250, 1, 110, 100);
		this.frame.getContentPane().add(heartRate);
		//-----------------------
		
		JLabel lblHeartRateIs = new JLabel("Heart Rate is:");
		lblHeartRateIs.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHeartRateIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRateIs.setBounds(10, 1, 250, 100);
		this.frame.getContentPane().add(lblHeartRateIs);
	}
	
	public void changeHR(String hr) {
		this.heartRate.setText(hr);
	}
	
}
