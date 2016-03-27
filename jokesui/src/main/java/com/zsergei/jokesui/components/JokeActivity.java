package com.zsergei.jokesui.components;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.zsergei.jokesui.IJokesUI;
import com.zsergei.jokesui.R;

import butterknife.Bind;

public class JokeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);

        String joke = extractJoke( getIntent() );
        jokeTextView.setText( joke );

    }



    @NonNull
    private String extractJoke(@NonNull final Intent intent) {
        String joke = intent.getStringExtra(IJokesUI.JOKE_KEY);

        if (joke != null) {
            return joke;
        } else {
            return "-";
        }
    }
}
