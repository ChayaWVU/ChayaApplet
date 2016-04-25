package domain.chaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

public class AlertActivity extends AppCompatActivity {

    String url = "https://amber-heat-6570.firebaseio.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

    }

    public void alert_onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.alert_button:
                new Firebase(url).child("Alert").setValue("false");
                startActivity(new Intent("domain.chaya.MainMenuActivity"));
                break;
        }
    }
}
