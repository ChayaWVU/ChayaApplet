package domain.chaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Date;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class MainMenuActivity extends AppCompatActivity {

    String url = "https://amber-heat-6570.firebaseio.com";
    TextView hr;
    TextView nextMed;
    TextView nextMedList;
    String medList = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        //initialize Firebase reference
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase(url);

        hr = (TextView) findViewById(R.id.heartRate_view);
        nextMed = (TextView) findViewById(R.id.nextMedicine_textView);
        nextMedList = (TextView) findViewById(R.id.nextMedList_textView);

        Calendar now = Calendar.getInstance();
        Date nowDate = new Date();
        now.setTime(nowDate);
        System.out.println(now.getTime());
        System.out.println(now.HOUR_OF_DAY);
        System.out.println(now.get(Calendar.HOUR_OF_DAY));


        Boolean morning = (8 <= now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < 12);
        Boolean afternoon = (12 <= now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < 16);
        Boolean evening = (16 <= now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < 20);
        Boolean night = (20 <= now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < 24);
        Boolean earlyMorning = (0 <= now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < 8);

        System.out.println(morning);
        System.out.println(afternoon);
        System.out.println(evening);
        System.out.println(night);
        System.out.println(earlyMorning);

        int timeSwitch = 0;
        int morningInt = 1;
        int afternoonInt = 2;
        int eveningInt = 3;
        int nightInt = 4;
        int earlyMorningInt = 5;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        String day = dateFormat.format(nowDate).toString();

        if(morning && !afternoon && !evening && !night && !earlyMorning) {
            timeSwitch = morningInt;
        }
        else if(!morning && afternoon && !evening && !night && !earlyMorning) {
            timeSwitch = afternoonInt;
        }
        else if(!morning && !afternoon && evening && !night && !earlyMorning) {
            timeSwitch = eveningInt;
        }
        else if(!morning && !afternoon && !evening && night && !earlyMorning) {
            timeSwitch = nightInt;
        }
        else if(!morning && !afternoon && !evening && !night && earlyMorning) {
            timeSwitch = earlyMorningInt;
        }

        switch(timeSwitch)
        {
            case 1:
                nextMed.setText(day + " Afternoon");

                ref.child(day).child("Afternoon").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        medList = "";
                        for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                            System.out.println(medicines.getValue().toString());
                            medList += medicines.getValue().toString() + ", ";
                        }
                        medList = medList.substring(0, medList.length() - 2);
                        nextMedList.setText(medList);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        return;
                    }
                });

                break;

            case 2:
                nextMed.setText(day + " Evening");


                ref.child(day).child("Evening").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        medList = "";
                        for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                            System.out.println(medicines.getValue().toString());
                            medList += medicines.getValue().toString() + ", ";
                        }
                        medList = medList.substring(0, medList.length() - 2);
                        nextMedList.setText(medList);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        return;
                    }
                });

                break;

            case 3:
                nextMed.setText(day + " Night");

                ref.child(day).child("Night").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        medList = "";
                        for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                            System.out.println(medicines.getValue().toString());
                            medList += medicines.getValue().toString() + ", ";
                        }
                        medList = medList.substring(0, medList.length() - 2);
                        nextMedList.setText(medList);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        return;
                    }
                });

                break;

            case 4:
                nextMed.setText(day + " Morning");

                ref.child(day).child("Morning").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        medList = "";
                        for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                            System.out.println(medicines.getValue().toString());
                            medList += medicines.getValue().toString() + ", ";
                        }
                        medList = medList.substring(0, medList.length() - 2);
                        nextMedList.setText(medList);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        return;
                    }
                });

                break;

            case 5:
                nextMed.setText(day + " Morning");

                ref.child(day).child("Morning").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        medList = "";
                        for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                            System.out.println(medicines.getValue().toString());
                            medList += medicines.getValue().toString() + ", ";
                        }
                        medList = medList.substring(0, medList.length() - 2);
                        nextMedList.setText(medList);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        return;
                    }
                });

                break;
        }


        ref.child("HeartRate").child("HeartRate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                hr.setText("Heartrate: " + snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        ref.child("Alert").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("true")) {
                    startActivity(new Intent("domain.chaya.AlertActivity"));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


    }
    public void onClickMainMenu(View view)
    {
        switch(view.getId())
        {
            case R.id.medicineSchedule_button:
                startActivity(new Intent("domain.chaya.EditMedicineActivity"));
                break;
        }
    }
}
