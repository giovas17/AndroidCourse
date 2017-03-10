package com.itexico.androidcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by darkgeat on 07/03/2017.
 */

public class Splash extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread delayThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        };
        delayThread.start();
    }
}
