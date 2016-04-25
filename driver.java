import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class driver {

	public static ArrayList<String> morningListItems = new ArrayList<String>();
	public static ArrayList<String> afternoonListItems = new ArrayList<String>();
	public static ArrayList<String> eveningListItems = new ArrayList<String>();
	public static ArrayList<String> nightListItems = new ArrayList<String>();
	
	public static void main (String[] args)  {
		
		Firebase hrRef = new Firebase("https://amber-heat-6570.firebaseIO.com");
		Date today = new Date();
		Calendar current = Calendar.getInstance();
		current.setTime(today);
		ChayaHome homePage = new ChayaHome();
		Emergency emergencyWindow = new Emergency();
		Schedule scheduleWindow = new Schedule();
		SendAlert sendAlertWindow = new SendAlert();
		AlertConfirmation alertConfirmationWindow = new AlertConfirmation();
		MedsTaken takenMedsWindow = new MedsTaken();
				
		new java.util.Timer().scheduleAtFixedRate(
				new java.util.TimerTask() {
					@Override
					public void run() {
						
						try {
							FileReader fr = new FileReader("test.txt");
							BufferedReader br = new BufferedReader(fr);
							String s;
							
								while((s = br.readLine()) != null) {
									hrRef.child("HeartRate").child("HeartRate").setValue(s);
								}
		
							fr.close();
						} 
						catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				},
				0, 1000
		);
		
		new java.util.Timer().scheduleAtFixedRate(
				new java.util.TimerTask() {
					@Override
					public void run() {
						if ((current.get(Calendar.HOUR_OF_DAY) == 8 || current.get(Calendar.HOUR_OF_DAY) == 12 || current.get(Calendar.HOUR_OF_DAY) == 16 || current.get(Calendar.HOUR_OF_DAY) == 20) &&
								current.get(Calendar.MINUTE) == 0) {
							new Firebase("https://amber-heat-6570.firebaseIO.com").child("MedsTaken").setValue("false");
							takenMedsWindow.initialize();
							takenMedsWindow.frame.setVisible(true);
							homePage.frame.dispose();
							emergencyWindow.frame.dispose();
							scheduleWindow.frame.dispose();
							sendAlertWindow.frame.dispose();
							homePage.frame.dispose();
							alertConfirmationWindow.frame.dispose();
						}
					}
				},
				0, 60000
		);
		
		hrRef.child("HeartRate").child("HeartRate").addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				homePage.changeHR(snapshot.getValue().toString());
			}

			@Override
			public void onCancelled(FirebaseError error) {
				System.out.println("Heart Rate reading failed: " + error.getMessage());
			}
		});
		
		homePage.initialize(true);
		homePage.frame.setVisible(true);
		
		
		homePage.emergencyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emergencyWindow.initialize();
				emergencyWindow.frame.setVisible(true);
				homePage.frame.dispose();
			}
		});

		homePage.medSchedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				scheduleWindow.initialize();
				scheduleWindow.frame.setVisible(true);
				homePage.frame.dispose();
			}
		});

		emergencyWindow.yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendAlertWindow.initialize();
				sendAlertWindow.frame.setVisible(true);
				emergencyWindow.frame.dispose();
			}
		});

		emergencyWindow.noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homePage.frame.setVisible(true);
				emergencyWindow.frame.dispose();
			}
		});
		
		scheduleWindow.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.frame.setVisible(true);
				scheduleWindow.frame.dispose();
			}
		});
		
		sendAlertWindow.sendAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Firebase("https://amber-heat-6570.firebaseIO.com").child("Alert").setValue("true");
				alertConfirmationWindow.initialize();
				alertConfirmationWindow.frame.setVisible(true);
				sendAlertWindow.frame.dispose();
			}
		});
		
		sendAlertWindow.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.frame.setVisible(true);
				sendAlertWindow.frame.dispose();
			}
		});
		
		
		alertConfirmationWindow.homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage.frame.setVisible(true);
				alertConfirmationWindow.frame.dispose();
			}
		});
		
		takenMedsWindow.takenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Firebase("https://amber-heat-6570.firebaseIO.com").child("MedsTaken").setValue("true");
				new Firebase("https://amber-heat-6570.firebaseIO.com").child("pin").setValue(0);
				homePage.frame.setVisible(true);
				takenMedsWindow.frame.dispose();
			}
		});
		
	}
}
