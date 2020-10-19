package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        text = (TextView)findViewById(R.id.textView);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task,6000);

        new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                text.setText(new SimpleDateFormat("ss").format(new Date(millisUntilFinished)));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
