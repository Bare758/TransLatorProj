package com.example.translatorproj;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    String sv;
    View Button;
    TextView speechText;

    private static final int RECOGNIZER_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button = findViewById(R.id.Button);
        speechText = findViewById(R.id.textView);
        button = findViewById(R.id.SaveBtn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == RECOGNIZER_RESULT && resultCode == RESULT_OK) ;
        {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            speechText.setText(matches.get(0));
            sv = matches.get(0);
            Log.d("result", sv);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void SaveBtn(View view) {
        Log.d("btn", "add btn works");

        Intent i = new Intent(MainActivity.this, saveData.SaveData.class);
        i.putExtra("Value", sv);
        startActivity(i);

    }

    public void btn(View view) {
        Log.d("btn1", "sound btn works");

        Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech to text");
        startActivityForResult(speechIntent, RECOGNIZER_RESULT);

    }



    }




