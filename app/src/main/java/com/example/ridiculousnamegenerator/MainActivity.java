package com.example.ridiculousnamegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
    }

    public void displayName(View v) {
        RandomNameGenerator nameObject = new RandomNameGenerator();
        ((TextView) findViewById(R.id.nameView)).setText(nameObject.generateName());
    }

    @Override
    public void onInit(int status) {
        this.tts.setLanguage(Locale.US);
    }

    public void speakName(View v) {
        String s = ((TextView) findViewById(R.id.nameView)).getText().toString();
        tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
    }
}
