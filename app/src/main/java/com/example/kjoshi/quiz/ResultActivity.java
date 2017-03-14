package com.example.kjoshi.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        String score=extras.getString(getIntent().EXTRA_TEXT);

        TextView text = (TextView) findViewById(R.id.score);
        text.setText(text.getText()+""+score);
    }
}
