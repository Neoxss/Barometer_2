package com.example.keila.barometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final AutoCompleteTextView email = (AutoCompleteTextView) findViewById(R.id.email);
        final AutoCompleteTextView password = (AutoCompleteTextView) findViewById(R.id.password);
        Button validate = (Button) findViewById(R.id.email_sign_in_button);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateEmail(email.getText().toString())) {
                    email.setError("Invalid Email");
                    email.requestFocus();

                } else if (!validatePassword(password.getText().toString())){
                    password.setError("Invalid Password");
                    password.requestFocus();

                } else {
                    Intent Button = new Intent(LoginActivity.this,Reports.class);
                    startActivity(Button);
                }

            }
        });

    }

    private boolean validateEmail(String email) {

        String emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();

    }



    private boolean validatePassword(String password) {

        if (password!=null && password.length()>9){
            return true;
        }
        else {
            return false;
        }


    }


    public void entre(View view) {
        Intent myIntent = new Intent(LoginActivity.this,Reports.class);
        startActivity(myIntent);
    }
}



