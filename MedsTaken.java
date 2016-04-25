import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MedsTaken {
	
	Firebase ref = new Firebase("https://amber-heat-6570.firebaseIO.com");
	protected JFrame frame;
	protected JButton takenButton;
	protected JLabel meds;
	Date today;
	Calendar current;
	ArrayList<String> morningListItems;
	ArrayList<String> afternoonListItems;
	ArrayList<String> eveningListItems;
	ArrayList<String> nightListItems;
	
	/**
	 * Constructor
	 */
	public MedsTaken() {
		frame = new JFrame();
		takenButton = new JButton("Medicines Taken");
		today = new Date();
		current = Calendar.getInstance();
		current.setTime(today);
		morningListItems = new ArrayList<String>();
		afternoonListItems = new ArrayList<String>();
		eveningListItems = new ArrayList<String>();
		nightListItems = new ArrayList<String>();
	}
	
	public void initialize() {
		int day = current.get(Calendar.DAY_OF_WEEK);
		int hour = current.get(Calendar.HOUR_OF_DAY);
		String dayString = "";
		String timeOfDay = "";
		
		switch (day) {
			case 1:
				dayString = "Sunday";
				break;
			case 2:
				dayString = "Monday";
				break;
			case 3:
				dayString = "Tuesday";
				break;
			case 4:
				dayString = "Wednesday";
				break;
			case 5:
				dayString = "Thursday";
				break;
			case 6:
				dayString = "Friday";
				break;
			case 7:
				dayString = "Saturday";
				break;
		}
		
		if (hour == 8) {
			timeOfDay = "Morning";
		}
		else if (hour == 12) {
			timeOfDay = "Afternoon";
		}
		else if (hour == 16) {
			timeOfDay = "Evening";
		}
		else if (hour == 20) {
			timeOfDay = "Night";
		}
		
		if(dayString.equals("Sunday") && timeOfDay.equals("Morning")) {
			//ref.child("pin").setValue(1);
		}
		else if(dayString.equals("Sunday") && timeOfDay.equals("Afternoon")){
			//ref.child("pin").setValue(1);
		}
		else if(dayString.equals("Sunday") && timeOfDay.equals("Evening")){
			//ref.child("pin").setValue(1);
		}
		else if(dayString.equals("Sunday") && timeOfDay.equals("Night")){
			//ref.child("pin").setValue(1);
		}
		else if(dayString.equals("Monday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(17);
		}
		else if(dayString.equals("Monday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(27);
		}
		else if(dayString.equals("Monday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(18);
		}
		else if(dayString.equals("Monday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(15);
		}
		else if(dayString.equals("Tuesday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(10);
		}
		else if(dayString.equals("Tuesday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(24);
		}
		else if(dayString.equals("Tuesday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(22);
		}
		else if(dayString.equals("Tuesday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(16);
		}
		else if(dayString.equals("Wednesday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(7);
		}
		else if(dayString.equals("Wednesday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(8);
		}
		else if(dayString.equals("Wednesday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(25);
		}
		else if(dayString.equals("Wednesday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(9);
		}
		else if(dayString.equals("Thursday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(12);
		}
		else if(dayString.equals("Thursday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(23);
		}
		else if(dayString.equals("Thursday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(11);
		}
		else if(dayString.equals("Thursday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(4);
		}
		else if(dayString.equals("Friday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(3);
		}
		else if(dayString.equals("Friday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(13);
		}
		else if(dayString.equals("Friday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(6);
		}
		else if(dayString.equals("Friday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(5);
		}
		else if(dayString.equals("Saturday") && timeOfDay.equals("Morning")){
			ref.child("pin").setValue(26);
		}
		else if(dayString.equals("Saturday") && timeOfDay.equals("Afternoon")){
			ref.child("pin").setValue(21);
		}
		else if(dayString.equals("Saturday") && timeOfDay.equals("Evening")){
			ref.child("pin").setValue(20);
		}
		else if(dayString.equals("Saturday") && timeOfDay.equals("Night")){
			ref.child("pin").setValue(19);
		}
		
		
		this.frame.setBounds(0, -30, 325, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		
		JLabel dayTimeLabel = new JLabel("Please Take " + dayString + " " + timeOfDay + "'s Medicines:");
		dayTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		dayTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayTimeLabel.setBounds(0, 0, 300, 100);
		this.frame.getContentPane().add(dayTimeLabel);
		
		JLabel lblItems = new JLabel("");
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItems.setHorizontalAlignment(SwingConstants.LEADING);
		lblItems.setBounds(80, 50, 250, 100);
		this.frame.getContentPane().add(lblItems);
		
		switch (timeOfDay) {
			case "Morning":
				ref.child(dayString).child(timeOfDay).addValueEventListener(new ValueEventListener(){
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
							
							lblItems.setText(morningItems);
						}
					
					}
					public void onCancelled(FirebaseError firebaseError){
						return;
					}
				});
				break;
			case "Afternoon":
				ref.child(dayString).child(timeOfDay).addValueEventListener(new ValueEventListener(){
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
							
							lblItems.setText(afternoonItems);
						}
					
					}
					public void onCancelled(FirebaseError firebaseError){
						return;
					}
				});
				break;
			case "Evening":
				ref.child(dayString).child(timeOfDay).addValueEventListener(new ValueEventListener(){
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
							
							lblItems.setText(eveningItems);
							
						}
					
					}
					public void onCancelled(FirebaseError firebaseError){
						return;
					}
				});
				break;
			case "Night":
				ref.child(dayString).child(timeOfDay).addValueEventListener(new ValueEventListener(){
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
							
							lblItems.setText(nightItems);
						}
					
					}
					public void onCancelled(FirebaseError firebaseError){
						return;
					}
				});
				break;
		}
		
		this.takenButton.setBounds(5, 175, 300, 60);
		this.takenButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.frame.getContentPane().add(takenButton);
	}
}
