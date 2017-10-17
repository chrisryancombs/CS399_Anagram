package com.example.ryan.myapplication;

import android.content.res.AssetManager;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Set;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    Set<String> myset = new HashSet<String>();
    Set<String> mylist = new HashSet<String>();
    String currentAns = "";
    int correctCount = 0;
    TextView ans;
    TextView cor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager a = getAssets();
        try {
            InputStream b = a.open("boggledict.txt");
            InputStreamReader streamReader = new InputStreamReader(b);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String l;
            while (( l = bufferedReader.readLine()) != null) {
                myset.add(l);
            }
        }
        catch (Exception e) {

        }



        ans = (TextView) findViewById(R.id.answer);
        cor = (TextView) findViewById(R.id.correct);




    }
    public void letterClk(View view) {
        Button current = (Button) view;
        String numChar = current.getText().toString();

        currentAns += numChar;
        ans.setText(currentAns);
    }

    public void evalClk(View view) {
        if (myset.contains(currentAns.toLowerCase()) && !mylist.contains(currentAns)) {
            correctCount++;
            cor.setText("Correct words: " + correctCount);

            mylist.add(currentAns);
            currentAns = "";
            ans.setText(currentAns);
        }
    }
}
