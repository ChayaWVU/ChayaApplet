package domain.chaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class RegisterActivity extends AppCompatActivity {


    String url = "https://amber-heat-6570.firebaseio.com";
    Firebase ref;
    EditText email;
    EditText password;
    EditText passwordConfirm;
    TextView registerCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        email = (EditText) findViewById(R.id.email_text);
        password = (EditText) findViewById(R.id.password_text);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm_text);
        registerCheck = (TextView) findViewById(R.id.registerCheck);

        final Button register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //need to check for empty password
                //error when username isnt email?
                //error handle for existing username
                if(password.getText().toString().equals(passwordConfirm.getText().toString())){

                    Firebase registerRef = new Firebase(url);
                    registerRef.createUser(email.getText().toString(),password.getText().toString(),new Firebase.ResultHandler() {

                        public void onSuccess() {
                            registerCheck.setText("Registration Successful");
                            email.setText("");
                            password.setText("");
                            passwordConfirm.setText("");

                        }

                        public void onError(FirebaseError fbError) {

                        }
                    });


                }
                else {
                    registerCheck.setText("Password doesn't match");
                    System.out.println(password.getText());
                    System.out.println(passwordConfirm.getText());
                }


            }
        });
    }
}
