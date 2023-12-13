package com.example.voiceassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    //Method to record the audio
    public void speak(View view)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");
        startActivityForResult(intent, 100);
    }

    //Conversion of audio to text
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK)
        {
            textView.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }

}