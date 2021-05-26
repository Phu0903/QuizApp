package com.example.multichose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    Button mRetryButton;
    TextView mFinalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button) findViewById(R.id.retry);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");
        mFinalScore.setText("You scored " + score + " out of " + Question.mQuestions.length);

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultsActivity.this,QuizActivity2.class);
                startActivity(i);
                ResultsActivity.this.finish();
            }
        });


    }
}