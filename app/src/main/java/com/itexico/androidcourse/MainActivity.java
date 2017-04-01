package com.itexico.androidcourse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordText);
        Button login = (Button)findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passValidation()){
                    Intent intent = new Intent(MainActivity.this,SimpleListActivity.class);
                    startActivity(intent);
                }
            }
        });

        Uri.Builder builder = Uri.parse("http://www.google.com").buildUpon();
        builder.appendPath("param");
        builder.appendPath("slack");
        builder.appendQueryParameter("id","0923849023");
        builder.appendQueryParameter("name","Giovas");
        Uri finalUri = builder.build();
        Log.d("Uri builder","url: " + finalUri.toString());

    }

    private boolean passValidation() {
        boolean passValidation = true;
        username.setError(null);
        password.setError(null);
        if (username.getText().toString().length() == 0){
            username.setError(getString(R.string.error_username_empty));
            passValidation = false;
        }
        if (password.getText().toString().length() == 0){
            password.setError(getString(R.string.error_password_empty));
            passValidation = false;
        }
        return passValidation;
    }
}
