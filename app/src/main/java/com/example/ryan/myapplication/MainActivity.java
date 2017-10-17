package com.example.ryan.myapplication;

import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import android.os.Bundle;
import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    TextView numAttempts;
    TextView numFound;
    TextView easySlot;

    long numberFound = 0;
    long numberAttempted = 0;
    int wordMaxCount;
    Bundle extras;
    String gameMode;

    String guess;

    Random random = new Random();

    ArrayList<String> wordList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extras  = getIntent().getExtras();
        gameMode = extras.getString("diff").toLowerCase();

        AssetManager a = getAssets();
        try {
            InputStream b = a.open("boggledict.txt");
            InputStreamReader streamReader = new InputStreamReader(b);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String l;
            while (( l = bufferedReader.readLine()) != null && gameMode.equals("easy")) {
                if (l.length() == 4){
                    wordList.add(l);
                }
            }

            while (( l = bufferedReader.readLine()) != null && gameMode.equals("medium")) {
                if (l.length() == 6){
                    wordList.add(l);
                }
            }

            while (( l = bufferedReader.readLine()) != null && gameMode.equals("hard")) {
                if (l.length() == 8){
                    wordList.add(l);
                }
            }
            generateButtons();
        }
        catch (Exception e) {
            System.out.println("ASDASDADASDASD");
        }

        numAttempts = (TextView) findViewById(R.id.attempts);
        numFound = (TextView) findViewById(R.id.wordsfound);
        easySlot = (TextView) findViewById(R.id.easySlot);

    }

    public void generateButtons() {
        if (gameMode.equals("easy")) {
            wordMaxCount = 4;
            int access = random.nextInt(wordList.size());
            String word = wordList.get(access);
            ArrayList shuffle = new ArrayList<String>();

            for (int i = 0; i < wordMaxCount; i ++) {
                shuffle.add(Character.toString(word.charAt(i)));
            }
            Collections.shuffle(shuffle);

            Button easyButton1 = (Button) findViewById(R.id.easyButton1);
            Button easyButton2 = (Button) findViewById(R.id.easyButton2);
            Button easyButton3 = (Button) findViewById(R.id.easyButton3);
            Button easyButton4 = (Button) findViewById(R.id.easyButton4);

            easyButton1.setVisibility(View.VISIBLE);
            easyButton2.setVisibility(View.VISIBLE);
            easyButton3.setVisibility(View.VISIBLE);
            easyButton4.setVisibility(View.VISIBLE);

            easyButton1.setText(shuffle.get(0).toString());
            easyButton2.setText(shuffle.get(1).toString());
            easyButton3.setText(shuffle.get(2).toString());
            easyButton4.setText(shuffle.get(3).toString());
        }

        else if (gameMode.equals("medium")) {
            wordMaxCount = 6;
            int access = random.nextInt(wordList.size());
            String word = wordList.get(access);
            ArrayList shuffle = new ArrayList<String>();

            for (int i = 0; i < wordMaxCount; i ++) {
                shuffle.add(Character.toString(word.charAt(i)));
            }
            Collections.shuffle(shuffle);

            Button normalButton1 = (Button) findViewById(R.id.normalButton1);
            Button normalButton2 = (Button) findViewById(R.id.normalButton2);
            Button normalButton3 = (Button) findViewById(R.id.normalButton3);
            Button normalButton4 = (Button) findViewById(R.id.normalButton4);
            Button normalButton5 = (Button) findViewById(R.id.normalButton5);
            Button normalButton6 = (Button) findViewById(R.id.normalButton6);

            normalButton1.setVisibility(View.VISIBLE);
            normalButton2.setVisibility(View.VISIBLE);
            normalButton3.setVisibility(View.VISIBLE);
            normalButton4.setVisibility(View.VISIBLE);
            normalButton5.setVisibility(View.VISIBLE);
            normalButton6.setVisibility(View.VISIBLE);


            normalButton1.setText(shuffle.get(0).toString());
            normalButton2.setText(shuffle.get(1).toString());
            normalButton3.setText(shuffle.get(2).toString());
            normalButton4.setText(shuffle.get(3).toString());
            normalButton5.setText(shuffle.get(4).toString());
            normalButton6.setText(shuffle.get(5).toString());

        }
        else if (gameMode.equals("hard")) {
            wordMaxCount = 8;
            int access = random.nextInt(wordList.size());
            String word = wordList.get(access);
            ArrayList shuffle = new ArrayList<String>();

            for (int i = 0; i < wordMaxCount; i ++) {
                shuffle.add(Character.toString(word.charAt(i)));
            }
            Collections.shuffle(shuffle);

            Button hardButton1 = (Button) findViewById(R.id.hardButton1);
            Button hardButton2 = (Button) findViewById(R.id.hardButton2);
            Button hardButton3 = (Button) findViewById(R.id.hardButton3);
            Button hardButton4 = (Button) findViewById(R.id.hardButton4);
            Button hardButton5 = (Button) findViewById(R.id.hardButton5);
            Button hardButton6 = (Button) findViewById(R.id.hardButton6);
            Button hardButton7 = (Button) findViewById(R.id.hardButton7);
            Button hardButton8 = (Button) findViewById(R.id.hardButton8);


            hardButton1.setVisibility(View.VISIBLE);
            hardButton2.setVisibility(View.VISIBLE);
            hardButton3.setVisibility(View.VISIBLE);
            hardButton4.setVisibility(View.VISIBLE);
            hardButton5.setVisibility(View.VISIBLE);
            hardButton6.setVisibility(View.VISIBLE);
            hardButton7.setVisibility(View.VISIBLE);
            hardButton8.setVisibility(View.VISIBLE);


            hardButton1.setText(shuffle.get(0).toString());
            hardButton2.setText(shuffle.get(1).toString());
            hardButton3.setText(shuffle.get(2).toString());
            hardButton4.setText(shuffle.get(3).toString());
            hardButton5.setText(shuffle.get(4).toString());
            hardButton6.setText(shuffle.get(5).toString());
            hardButton7.setText(shuffle.get(6).toString());
            hardButton8.setText(shuffle.get(7).toString());


        }
    }
    public void buttonClickAppend(View view) {
        Button current = (Button) view;
        String letter = current.getText().toString();
        if (guess == null) {
            guess =  letter;
        }
        else if (guess.length() < wordMaxCount) {
            guess += letter;
        }
        easySlot.setText(guess);
    }

    public void resetClicked(View view) {
        guess = "";
        easySlot.setText(guess);
    }

    public void enterClicked(View view) {
        if(wordList.contains(guess.toLowerCase())) {
            numberFound++;
        }
        numberAttempted++;

        numFound.setText("Words found: " + String.valueOf(numberFound));
        numAttempts.setText("Attempts: " + String.valueOf(numberAttempted));

        resetClicked(view);
        generateButtons();
    }

    public void goToResults(View view) {
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);

        intent.putExtra("numberAttempted", numberAttempted);
        intent.putExtra("numberFound", "" + numberFound);
        intent.putExtra("diff", gameMode.toUpperCase());

        startActivity(intent);
    }

    public void goToAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
