package com.example.ridiculousnamegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayName(View v) {
        RandomNameGenerator name = new RandomNameGenerator();
        ((TextView) findViewById(R.id.nameView)).setText(name.generateName());
    }
}
