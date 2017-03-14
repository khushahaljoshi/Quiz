package com.example.kjoshi.quiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import 	android.os.Handler;
import java.util.logging.LogRecord;

public class questionActivity extends AppCompatActivity {
    ArrayList<Question> question;
    TextView ques,timer;
    Button A, B, C, D,  clicked = A;
    boolean click = false;
    int flag = 0,score=0,next=1, index = 0;
    Handler handle = new Handler() ;
    Runnable run;
    long tick=0;
    MyCount counter = new MyCount(15000,1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        question = new ArrayList<Question>();


        ques = (TextView) findViewById(R.id.question);
        timer=(TextView) findViewById(R.id.timer);
        A = (Button) findViewById(R.id.optionA);
        B = (Button) findViewById(R.id.optionB);
        C = (Button) findViewById(R.id.optionC);
        D = (Button) findViewById(R.id.optionD);


        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is the fastest writable memory?", "RAM", "Flash", "Register", "rom", C));
        question.add(new Question("What's ingrown if yourr suffer from onychrocriptocis.", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is the fastest writable memory?", "RAM", "Flash", "Register", "rom", C));
        question.add(new Question("What's ingrown if yourr suffer from onychrocriptocis.", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));
        question.add(new Question("Which of the following is not interpreter language", "Ruby", "Python", "java", "Basic", D));



        ques.setText(question.get(index).getQUESTION());
        A.setText(question.get(index).getOPTA());
        B.setText(question.get(index).getOPTB());
        C.setText(question.get(index).getOPTC());
        D.setText(question.get(index).getOPTD());

        //delay(15000);
        counter.start();

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    click=true;
                    clicked = A;
                    if (question.get(index).getANSWER() == A) {
                        A.setBackgroundColor(Color.parseColor("#33691E"));
                        scoreCard(tick);
                    } else {
                        A.setBackgroundColor(Color.parseColor("#B71C1C"));
                        question.get(index).getANSWER().setBackgroundColor(Color.parseColor("#33691E"));
                    }
                    flag = 1;
                    handle.removeCallbacks(run);
                    delay(5000);
                    counter.cancel();

                }
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 0) {
                    click=true;
                    clicked = B;
                    if (question.get(index).getANSWER() == B) {
                        B.setBackgroundColor(Color.parseColor("#33691E"));
                        scoreCard(tick);
                    } else {
                        B.setBackgroundColor(Color.parseColor("#B71C1C"));
                        question.get(index).getANSWER().setBackgroundColor(Color.parseColor("#33691E"));
                    }
                    flag = 1;
                    handle.removeCallbacks(run);
                    delay(5000);
                    counter.cancel();


                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 0) {
                    click=true;
                    clicked = C;
                    if (question.get(index).getANSWER()==C) {
                        C.setBackgroundColor(Color.parseColor("#33691E"));
                        scoreCard(tick);
                    } else {
                        C.setBackgroundColor(Color.parseColor("#B71C1C"));
                        question.get(index).getANSWER().setBackgroundColor(Color.parseColor("#33691E"));
                    }
                    flag = 1;
                    handle.removeCallbacks(run);
                    delay(5000);
                    counter.cancel();
                }
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    click=true;
                    clicked = D;
                    if (question.get(index).getANSWER()==D) {
                        D.setBackgroundColor(Color.parseColor("#33691E"));
                        scoreCard(tick);
                    } else {
                        D.setBackgroundColor(Color.parseColor("#B71C1C"));
                        question.get(index).getANSWER().setBackgroundColor(Color.parseColor("#33691E"));
                    }
                    flag = 1;
                    handle.removeCallbacks(run);
                    delay(5000);
                    counter.cancel();
                }
            }
        });

    }

    public questionActivity()
    {

    }

    public void next() {
        if(next<10) {

            flag = 0;
            if (click) {

                clicked.setBackgroundResource(android.R.drawable.btn_default);
                click = false;
            }
            question.get(index).getANSWER().setBackgroundResource(android.R.drawable.btn_default);
            index += 1;
            ques.setText(question.get(index).getQUESTION());
            A.setText(question.get(index).getOPTA());
            B.setText(question.get(index).getOPTB());
            C.setText(question.get(index).getOPTC());
            D.setText(question.get(index).getOPTD());
            //handle.removeCallbacks(run);
            counter.start();
            next+=1;
            Log.i("the value of score"+getScore(), "score " + score);

        }
        else{
            Intent intent = new Intent(questionActivity.this,ResultActivity.class);
            intent.putExtra(android.content.Intent.EXTRA_TEXT, ""+getScore());
            startActivity(intent);
        }


    }

    public void delay(long TIME_OUT) {

        run=new Runnable() {
            @Override
            public void run() {
                next(   );
            }
        };
        handle.postDelayed(run, TIME_OUT);
    }

    public void scoreCard(long time)
    {
        if(time>=10){
            score+=10;
        }

        else if(time>=5){
            score+=9;
        }
        else{
            score+=8;
        }
    }

    public long getScore()
    {
        return score;

    }

    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            flag=1;
            delay(5000);
            question.get(index).getANSWER().setBackgroundColor(Color.parseColor("#33691E"));

        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText(""+millisUntilFinished / 1000);
            tick=millisUntilFinished / 1000;

        }
    }
}