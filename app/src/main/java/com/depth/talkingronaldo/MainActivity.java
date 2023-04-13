package com.depth.talkingronaldo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity implements View.OnTouchListener {
    private MediaPlayer mediaPlayer;
    private Button btnSpeak;
    private ImageView imgTom;
    private int[] soundIds = {R.raw.sound1, R.raw.sound2, R.raw.sound3, R.raw.sound4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        int randomIndex = new Random().nextInt(soundIds.length);
        int soundId = soundIds[randomIndex];

        mediaPlayer = MediaPlayer.create(this,soundId);
        btnSpeak = findViewById(R.id.btn_speak);
        imgTom = findViewById(R.id.img_tom);

        btnSpeak.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mediaPlayer.start();
            imgTom.setImageResource(R.mipmap.talking_tom_talk);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            mediaPlayer.pause();
            imgTom.setImageResource(R.mipmap.talking_tom);
        }
        return true;
    }
    public void refreshActivity(View view) {
        recreate();
    }

}
