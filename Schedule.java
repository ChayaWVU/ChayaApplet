import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Schedule {

	Firebase ref = new Firebase("https://amber-heat-6570.firebaseIO.com");
	protected JFrame frame;
	protected JButton backButton;
	ArrayList<String> morningListItems;
	ArrayList<String> afternoonListItems;
	ArrayList<String> eveningListItems;
	ArrayList<String> nightListItems;
	
	
	/**
	 * Constructor
	 */
	public Schedule() {
		frame = new JFrame();
		backButton = new JButton("Back");
		
		morningListItems = new ArrayList<String>();
		afternoonListItems = new ArrayList<String>();
		eveningListItems = new ArrayList<String>();
		nightListItems = new ArrayList<String>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		Date now = new Date();
		SimpleDateFormat today = new SimpleDateFormat("EEEE");
		String day = today.format(now).toString();
		
		JLabel lblMedicineSchedule = new JLabel( today.format(now) + "'s Medicine Schedule");
		lblMedicineSchedule.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMedicineSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicineSchedule.setBounds(30, -40, 250, 100);//x,y,width,height
		this.frame.getContentPane().add(lblMedicineSchedule);
		
		JLabel lblMorning = new JLabel( "Morning: ");
		lblMorning.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMorning.setHorizontalAlignment(SwingConstants.LEADING);
		lblMorning.setBounds(18, 0, 250, 100);
		this.frame.getContentPane().add(lblMorning);
		
		JLabel lblMorningItems = new JLabel("");
		lblMorningItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMorningItems.setHorizontalAlignment(SwingConstants.LEADING);
		lblMorningItems.setBounds(80, 0, 250, 100);
		this.frame.getContentPane().add(lblMorningItems);
		
		JLabel lblAfternoon = new JLabel( "Afternoon: ");
		lblAfternoon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAfternoon.setHorizontalAlignment(SwingConstants.LEADING);
		lblAfternoon.setBounds(5, 40, 250, 100);
		this.frame.getContentPane().add(lblAfternoon);
		
		JLabel lblAfternoonItems = new JLabel( "");
		lblAfternoonItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAfternoonItems.setHorizontalAlignment(SwingConstants.LEADING);
		lblAfternoonItems.setBounds(80, 40, 250, 100);
		this.frame.getContentPane().add(lblAfternoonItems);
		
		JLabel lblEvening = new JLabel( "Evening: ");
		lblEvening.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEvening.setHorizontalAlignment(SwingConstants.LEADING);
		lblEvening.setBounds(18, 80, 250, 100);
		this.frame.getContentPane().add(lblEvening);
		
		JLabel lblEveningItems = new JLabel( "");
		lblEveningItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEveningItems.setHorizontalAlignment(SwingConstants.LEADING);
		lblEveningItems.setBounds(80, 80, 250, 100);
		this.frame.getContentPane().add(lblEveningItems);
		
		JLabel lblNight = new JLabel( "Night: ");
		lblNight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNight.setHorizontalAlignment(SwingConstants.LEADING);
		lblNight.setBounds(34, 120, 250, 100);
		this.frame.getContentPane().add(lblNight);
		
		JLabel lblNightItems = new JLabel( "");
		lblNightItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNightItems.setHorizontalAlignment(SwingConstants.LEADING);
		lblNightItems.setBounds(80, 120, 250, 100);
		this.frame.getContentPane().add(lblNightItems);
		
		this.backButton.setBounds(0, 200, 100, 40);
		this.backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.frame.getContentPane().add(backButton);
		
		ref.child(day).child("Morning").addValueEventListener(new ValueEventListener(){
			public void onDataChange(DataSnapshot dataSnapshot){
				morningListItems.clear();
				String morningItems = "";
				int commaInc = 0;
				for (DataSnapshot medicines : dataSnapshot.getChildren()) {
					morningListItems.add(medicines.getValue().toString());
					if (commaInc == 0) {
						morningItems = morningItems + medicines.getValue().toString();
						commaInc++;
					}
					else { 
						morningItems = morningItems + ", " + medicines.getValue().toString();
						commaInc++;
					}
					
					lblMorningItems.setText(morningItems);
				}
			
			}
			public void onCancelled(FirebaseError firebaseError){
				return;
			}
		});
		
		ref.child(day).child("Afternoon").addValueEventListener(new ValueEventListener(){
			public void onDataChange(DataSnapshot dataSnapshot){
				afternoonListItems.clear();
				String afternoonItems = "";
				int commaInc = 0;
				for (DataSnapshot medicines : dataSnapshot.getChildren()){
					afternoonListItems.add(medicines.getValue().toString());
					if (commaInc == 0) {
						afternoonItems = afternoonItems + medicines.getValue().toString();
						commaInc++;
					}
					else { 
						afternoonItems = afternoonItems + ", " + medicines.getValue().toString();
						commaInc++;
					}
					
					lblAfternoonItems.setText(afternoonItems);
				}
			
			}
			public void onCancelled(FirebaseError firebaseError){
				return;
			}
		});
		
		ref.child(day).child("Evening").addValueEventListener(new ValueEventListener(){
			public void onDataChange(DataSnapshot dataSnapshot){
				eveningListItems.clear();
				String eveningItems = "";
				int commaInc = 0;
				for (DataSnapshot medicines : dataSnapshot.getChildren()){
					eveningListItems.add(medicines.getValue().toString());
					if (commaInc == 0) {
						eveningItems = eveningItems + medicines.getValue().toString();
						commaInc++;
					}
					else { 
						eveningItems = eveningItems + ", " + medicines.getValue().toString();
						commaInc++;
					}
					
					lblEveningItems.setText(eveningItems);
					
				}
			
			}
			public void onCancelled(FirebaseError firebaseError){
				return;
			}
		});
		
		ref.child(day).child("Night").addValueEventListener(new ValueEventListener(){
			public void onDataChange(DataSnapshot dataSnapshot){
				nightListItems.clear();
				String nightItems = "";
				int commaInc = 0;
				for (DataSnapshot medicines : dataSnapshot.getChildren()){
					nightListItems.add(medicines.getValue().toString());
					if (commaInc == 0) {
						nightItems = nightItems + medicines.getValue().toString();
						commaInc++;
					}
					else { 
						nightItems = nightItems + ", " + medicines.getValue().toString();
						commaInc++;
					}
					
					lblNightItems.setText(nightItems);
				}
			
			}
			public void onCancelled(FirebaseError firebaseError){
				return;
			}
		});

		
	}
}
