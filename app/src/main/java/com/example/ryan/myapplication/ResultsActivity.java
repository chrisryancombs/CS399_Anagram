package com.example.ryan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras  = getIntent().getExtras();
        String diff = extras.getString("diff");
        String correct = extras.getString("score");

        TextView message = (TextView) findViewById(R.id.message);
        message.setText("You played: " + diff + " MODE");

        TextView number = (TextView) findViewById(R.id.correct);
        number.setText("And you managed to find " + correct + " correct words!");
    }
}
