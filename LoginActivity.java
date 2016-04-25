package domain.chaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;



public class LoginActivity extends AppCompatActivity {

    String url = "https://amber-heat-6570.firebaseio.com";
    Firebase ref;
    EditText email;
    EditText password;
    TextView loginCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize Firebase reference
        Firebase.setAndroidContext(this);
        ref = new Firebase(url);

        //Have to find the Views that we want to access from here
        email = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        loginCheck = (TextView) findViewById(R.id.loginCheck);

        loginCheck.setText("");


    }
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.login_button:
                Firebase userRef= new Firebase(url);

                Firebase.AuthResultHandler arh = new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        loginCheck.setText("Login Success");


                        startActivity(new Intent("domain.chaya.MainMenuActivity"));

                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        loginCheck.setText("Login Fail");
                    }
                };

                userRef.authWithPassword(email.getText().toString(),password.getText().toString(),arh);
                break;

            case R.id.register_button:
                startActivity(new Intent("domain.chaya.RegisterActivity"));
                break;
        }
    }
}

