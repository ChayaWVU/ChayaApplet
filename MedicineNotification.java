
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicineNotification {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicineNotification window = new MedicineNotification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicineNotification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 950, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setBounds(317, 108, 227, 81);
		frame.getContentPane().add(lblMonday);
		
		JLabel lblMorning = new JLabel("Morning");
		lblMorning.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorning.setBounds(317, 200, 227, 81);
		frame.getContentPane().add(lblMorning);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicine.setBounds(330, 304, 214, 55);
		frame.getContentPane().add(lblMedicine);
		
		JLabel lblTake = new JLabel("Take");
		lblTake.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTake.setHorizontalAlignment(SwingConstants.CENTER);
		lblTake.setBounds(317, 41, 227, 56);
		frame.getContentPane().add(lblTake);
		
		JButton btnNewButton = new JButton("Medicine Taken");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ChayaHome HomeWindow = new ChayaHome();
				//changeColor(2);
				//HomeWindow.HomeScreen();
				
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(298, 434, 263, 127);
		frame.getContentPane().add(btnNewButton);
	}

}
