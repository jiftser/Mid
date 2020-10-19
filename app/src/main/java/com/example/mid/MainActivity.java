package com.example.mid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    MediaPlayer mp3 = new MediaPlayer();
    int playing = 0;
    Button bttn1;
    Button bttn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn1 = (Button)findViewById(R.id.button);
        bttn2 = (Button)findViewById(R.id.button2);

        mp3 = MediaPlayer.create(this, R.raw.track1);
        image = (ImageView)findViewById(R.id.imageView2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing){
                    case 0:
                        mp3.start();
                        playing = 1;
                        break;
                    case 1:
                        mp3.pause();
                        playing = 0;
                        break;
                }
            }
        });
        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
    }
}
