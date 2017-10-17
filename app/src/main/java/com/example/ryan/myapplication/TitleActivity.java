package com.example.ryan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void goToGame(View view)
    {
        Button current = (Button) view;
        String difficulty = current.getText().toString();

        Intent intent = new Intent(TitleActivity.this, MainActivity.class);
        intent.putExtra("diff", difficulty);

        startActivity(intent);
    }
}
