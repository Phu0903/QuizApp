package com.example.multichose;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button mStartButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartButton = (Button) findViewById(R.id.startButton); //Tìm ID button Start
        mStartButton.setOnClickListener(new View.OnClickListener() { //Tạo sự kiện cho startButton
            @Override
            public void onClick(View v) {
                //Activity nhận intent đó là QuizActivity2
                Intent i = new Intent(MainActivity.this,QuizActivity2.class);
                //Chuyển sang QuizActivity2
                startActivity(i);
            }
        });
    }
}