package com.example.trainyourbrain;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswers;
    int score = 0;
    int questions = 0;
    ConstraintLayout consLayout;

    public void playAgain(final View view){

        score = 0;
        questions = 0;

        timerTextView.setText(getString(R.string._30s));
        pointsTextView.setText(getString(R.string._0_0));
        resultTextView.setText(getString(R.string.answering));
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuestion();

        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText(getString(R.string.sec_finish));
                resultTextView.setText(getString(R.string.your_score, score));
            }
        }.start();

    }

    public void generateQuestion () {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(getString(R.string.welcome_messages, a, b));

        locationOfCorrectAnswers = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++){

            int incorrectAnswer;

            if(i == locationOfCorrectAnswers){
                answers.add( a + b );
            }
            else{
                incorrectAnswer = rand.nextInt(41);

                while( incorrectAnswer == a + b){
                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        button3.setText(String.valueOf(answers.get(0)));
        button4.setText(String.valueOf(answers.get(1)));
        button5.setText(String.valueOf(answers.get(2)));
        button6.setText(String.valueOf(answers.get(3)));

    }

    public void startGame(View view){
        startButton.setVisibility(View.INVISIBLE);
        consLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }

    public void answer1(View view) {

        if(locationOfCorrectAnswers == 0){
            score++;
            resultTextView.setText(getString(R.string.display));
        }
        else{
            resultTextView.setText(getString(R.string.play));
        }

        questions++;
        pointsTextView.setText(getString(R.string.point, score, questions));
        generateQuestion();

    }

    public void answer2(View view) {

        if(locationOfCorrectAnswers == 1){
            score++;
            resultTextView.setText(getString(R.string.display));
        }
        else{
            resultTextView.setText(getString(R.string.play));
        }

        questions++;
        pointsTextView.setText(getString(R.string.point, score, questions));
        generateQuestion();

    }

    public void answer3(View view) {

        if(locationOfCorrectAnswers == 2){
            score++;
            resultTextView.setText(getString(R.string.display));
        }
        else{
            resultTextView.setText(getString(R.string.play));
        }

        questions++;
        pointsTextView.setText(getString(R.string.point, score, questions));
        generateQuestion();

    }

    public void answer4(View view) {

        if(locationOfCorrectAnswers == 3){
            score++;
            resultTextView.setText(getString(R.string.display));
        }
        else{
            resultTextView.setText(getString(R.string.play));
        }

        questions++;
        pointsTextView.setText(getString(R.string.point, score, questions));
        generateQuestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        resultTextView = findViewById(R.id.resultTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        sumTextView = findViewById(R.id.sumTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        consLayout = findViewById(R.id.consLayout);

    }
}
