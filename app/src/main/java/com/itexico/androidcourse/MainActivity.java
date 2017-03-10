package com.itexico.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
