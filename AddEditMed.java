package domain.chaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.view.View;
import java.util.ArrayList;

import android.widget.Spinner;
import android.widget.ListView;

public class AddEditMed extends AppCompatActivity {

    EditText addMed;
    Spinner time;
    String[] spinArray;
    String url = "https://amber-heat-6570.firebaseio.com";
    Firebase ref = new Firebase(url);
    String day;
    TextView dayView;

    ListView morningMedList;
    ListView afternoonMedList;
    ListView eveningMedList;
    ListView nightMedList;

    ArrayList<String> morningListItems = new ArrayList<String>();
    ArrayList<String> afternoonListItems = new ArrayList<String>();
    ArrayList<String> eveningListItems = new ArrayList<String>();
    ArrayList<String> nightListItems = new ArrayList<String>();

    ArrayAdapter<String> morningAdapter;
    ArrayAdapter<String> afternoonAdapter;
    ArrayAdapter<String> eveningAdapter;
    ArrayAdapter<String> nightAdapter;
    ArrayAdapter<String> removeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_med);

        dayView = (TextView) findViewById(R.id.currentDay_textView);
        addMed = (EditText) findViewById(R.id.addMed_editText);
        time = (Spinner) findViewById(R.id.time_spinner);
        spinArray = new String[] {"Morning", "Afternoon", "Evening", "Night"};
        morningMedList = (ListView) findViewById(R.id.morningMed_listView);
        afternoonMedList = (ListView) findViewById(R.id.afternoonMed_listView);
        eveningMedList = (ListView) findViewById(R.id.eveningMed_listView);
        nightMedList = (ListView) findViewById(R.id.nightMed_listView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            day = extras.getString("KEY");
        }

        dayView.setText(day + " Medicines");
        addMed.setText("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinArray);
        time.setAdapter(adapter);

        morningAdapter = new ArrayAdapter<String>(this, R.layout.my_list_view, morningListItems);
        morningMedList.setAdapter(morningAdapter);

        afternoonAdapter = new ArrayAdapter<String>(this, R.layout.my_list_view, afternoonListItems);
        afternoonMedList.setAdapter(afternoonAdapter);

        eveningAdapter = new ArrayAdapter<String>(this, R.layout.my_list_view, eveningListItems);
        eveningMedList.setAdapter(eveningAdapter);

        nightAdapter = new ArrayAdapter<String>(this, R.layout.my_list_view, nightListItems);
        nightMedList.setAdapter(nightAdapter);

        ref.child(day).child("Morning").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                morningListItems.clear();
                for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                    morningListItems.add(medicines.getValue().toString());
                }
                morningAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                return;
            }
        });

        ref.child(day).child("Afternoon").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                afternoonListItems.clear();
                for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                    afternoonListItems.add(medicines.getValue().toString());
                }
                afternoonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                return;
            }
        });

        ref.child(day).child("Evening").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eveningListItems.clear();
                for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                    eveningListItems.add(medicines.getValue().toString());
                }
                eveningAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                return;
            }
        });

        ref.child(day).child("Night").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nightListItems.clear();
                for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                    nightListItems.add(medicines.getValue().toString());
                }
                nightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                return;
            }
        });

    }

    public void addMed_onClick(View view) {
        if(addMed.getText().toString().length() > 0) {
            ref.child(day).child(time.getSelectedItem().toString()).push().setValue(addMed.getText().toString());
            addMed.setText("");
        }
    }

    public void removeMed_onClick(View view) {
        if(addMed.getText().toString().length() > 0) {

            switch(time.getSelectedItem().toString().trim())
            {

                case "Morning":
                    removeAdapter = this.morningAdapter;
                    break;

                case "Afternoon":
                    removeAdapter = this.afternoonAdapter;
                    break;

                case "Evening":
                    removeAdapter = this.eveningAdapter;
                    break;

                case "Night":
                    removeAdapter = this.nightAdapter;
                    break;
            }

            ref.child(day).child(time.getSelectedItem().toString()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot medicines : dataSnapshot.getChildren()) {
                        if (medicines.getValue().toString().trim().equalsIgnoreCase(addMed.getText().toString().trim())) {
                            ref.child(day).child(time.getSelectedItem().toString()).child(medicines.getKey().toString()).removeValue();
                        }
                    }
                    removeAdapter.notifyDataSetChanged();
                    addMed.setText("");

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    return;
                }
            });


        }
    }


}
