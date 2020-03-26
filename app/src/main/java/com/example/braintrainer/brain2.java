package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class brain2 extends AppCompatActivity {

    ArrayList<Integer> answer = new ArrayList<Integer>();
    int location;
    int score = 0;
    TextView result ,pointtextview , sum , timer;
    int question = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagain;


    public void playagain(View view){
        score =0 ;
        question= 0 ;
        timer.setText("60 s");
        pointtextview.setText("0/0");
        result.setText("");
        playagain.setVisibility(View.INVISIBLE);
        generatequestions();
        new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                timer.setText("0s");
                result.setText("Your Score " + Integer.toString(score) + "/" + Integer.toString(question));
            }
        }.start();
    }public void generatequestions(){
        Random ran = new Random();
        int a = ran.nextInt(30);
        int b = ran.nextInt(30);
        sum.setText(Integer.toString(a) + "+" + Integer.toString(b));
        location = ran.nextInt(4);
        int incorrectanswer;
        answer.clear();

        for (int i = 0; i < 4; i++) {
            if (i == location) {

                answer.add(a + b);
            } else {
                incorrectanswer = ran.nextInt(58);
                while (incorrectanswer == a + b)
                { incorrectanswer = ran.nextInt(58);
                }
                answer.add(incorrectanswer);
            }
        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }
    public  void correctanswer(View view) {
        if(view.getTag().toString().equals(Integer.toString(location)))
        { score++;
            result.setText("CORRECT !");
        }
        else {

            result.setText("WRONG !");
        }
        question ++;
        pointtextview.setText(Integer.toString(score) + "/" + Integer.toString(question));
        generatequestions();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain2);

        sum = (TextView) findViewById(R.id.sumtextview);
        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        result = (TextView) findViewById(R.id.result);
        pointtextview = (TextView) findViewById(R.id.pointstextview);
        timer = (TextView) findViewById(R.id.timertextview);
        playagain = (Button) findViewById(R.id.playagain);
        playagain(findViewById(R.id.playagain));
    }
}
