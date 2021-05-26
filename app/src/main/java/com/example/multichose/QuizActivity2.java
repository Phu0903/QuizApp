package com.example.multichose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity2 extends AppCompatActivity {
    private Question mQuestionLibrary = new Question(); // Gọi đến dữ liệu
    private TextView textView,timeText;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private String mAnswer;
    private int mScore = 0 ;//Tính điểm
    private String strChoice1,strChoice2,strChoice3,strChoice4;
    private int mQuestionNumber = 0 ; //Câu hỏi ban đầu
    private ImageView mImageView;
    CountDownTimer countDownTimer;
    //xét time = 30
    int timeValue = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        //Gọi ra câu hỏi , ảnh , câu trả lời đầu
        updateQuestion();
        //Tạo sự kiện cho nút A
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nếu là câu trả lời đúng
                if (strChoice1 == mAnswer)
                {

                    //Hiện câu trà lời đúng
                    //Toast.makeText(QuizActivity2.this, "Câu trả lời đúng", Toast.LENGTH_SHORT).show();
                    //Hàm refults
                    mScore++;
                    refults();
                }
                else{

                    refults();
                }

            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strChoice2 == mAnswer)
                {

                    //Toast.makeText(QuizActivity2.this, "Câu trả lời đúng", Toast.LENGTH_SHORT).show();
                    mScore++;
                    refults();


                }
                else{

                    refults();
                }

            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strChoice3 == mAnswer)
                {

                    //Toast.makeText(QuizActivity2.this, "Câu trả lời đúng", Toast.LENGTH_SHORT).show();
                    mScore++;
                    refults();


                }
                else{

                    refults();
                }

            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strChoice4 == mAnswer)
                {

                    //Toast.makeText(QuizActivity2.this, "Câu trả lời đúng", Toast.LENGTH_SHORT).show();
                    mScore++;
                    refults();


                }
                else{

                    refults();
                }

            }
        });
        countDownTimer = new CountDownTimer(32000, 1000) {
            public void onTick(long millisUntilFinished) {

                //here you can have your logic to set text to timeText
                timeText.setText(String.valueOf(timeValue) + " s");

                //With each iteration decrement the time by 1 sec
                timeValue -= 1;

                //This means the user is out of time so onFinished will called after this iteration
                if (timeValue == -1) {

                    acyivityRefults();
                    //resultText.setText(getString(R.string.timeup));
                }
            }

            //Người chơi hết thời gian
            public void onFinish() {

                refults();
            }
        }.start();


}
    //Ánh xạ với view
    private void init()
    {
        //Tìm id cho câu hỏi
        textView = (TextView) findViewById(R.id.textView);
        //ID ảnh
        mImageView = (ImageView)findViewById(R.id.imageView);
        //ID button A
        mButtonChoice1 = (Button) findViewById(R.id.buttonA);
        //ID button B
        mButtonChoice2 = (Button) findViewById(R.id.buttonB);
        //ID button C
        mButtonChoice3 = (Button) findViewById(R.id.buttonC);
        //ID button D
        mButtonChoice4 = (Button) findViewById(R.id.buttonD);
        //time
        timeText = (TextView) findViewById(R.id.timeText);

    }
    //Update lại câu hỏi câu trả lời
    private void updateQuestion(){
        //Gọi hàm init
        init();
        //Gọi đến các resources: strings
        Resources resources  = getResources();
        //Lấy câu hỏi từ dữ liệu theo thứ tự mảng
        String strQuestion = mQuestionLibrary.getQuestion(mQuestionNumber);
        //set Text trong xml có gán thêm strings
        textView.setText( String.format(resources.getString( R.string.text_question),strQuestion));
        //Lấy ảnh từ dữ liệu gán vào xml
        mImageView.setImageResource(mQuestionLibrary.images[mQuestionNumber]);
        //Lấy các lựa chọn từ data
        strChoice1 = mQuestionLibrary.getChoice1(mQuestionNumber);
        strChoice2 = mQuestionLibrary.getChoice2(mQuestionNumber);
        strChoice3 = mQuestionLibrary.getChoice3(mQuestionNumber);
        strChoice4 = mQuestionLibrary.getChoice4(mQuestionNumber);
        //gán các lựa chọn vào xml
        mButtonChoice1.setText(String.format(resources.getString(R.string.button_A),strChoice1));
        mButtonChoice2.setText(String.format(resources.getString(R.string.button_B),strChoice2));
        mButtonChoice3.setText(String.format(resources.getString(R.string.button_C),strChoice3));
        mButtonChoice4.setText(String.format(resources.getString(R.string.button_D),strChoice4));
        //Câu trả lời đúng
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        //tăng số thứ tự của câu hỏi
        mQuestionNumber++;



    }
    //kết quả
    private void refults()
    {
        if(mQuestionNumber == mQuestionLibrary.mQuestions.length)
        {
            acyivityRefults();
            countDownTimer.cancel();
        }
        else
        {
            updateQuestion();
        }
    }
    private void acyivityRefults()
    {
        //sử dụng Bundle để truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putInt("finalScore",mScore );
        Intent i = new Intent(QuizActivity2.this, ResultsActivity.class);
        i.putExtras(bundle);
        QuizActivity2.this.finish();
        startActivity(i);
    }


}

