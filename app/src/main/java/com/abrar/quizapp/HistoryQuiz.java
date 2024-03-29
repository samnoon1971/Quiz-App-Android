package com.abrar.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistoryQuiz extends AppCompatActivity {
    private Button optionBtn1, optionBtn2, optionBtn3, optionBtn4;
    private TextView intro_Question, timerText;
    private int correct = 0, wrong = 0, total = 0;
    DatabaseReference reference;
    private int totalQuestions, totalSeconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_quiz);
        optionBtn1 = (Button) findViewById(R.id.history_btn1);
        optionBtn2 = (Button) findViewById(R.id.history_btn2);
        optionBtn3 = (Button) findViewById(R.id.history_btn3);
        optionBtn4 = (Button) findViewById(R.id.history_btn4);
        intro_Question = (TextView) findViewById(R.id.hquizintro);
        timerText = (TextView) findViewById(R.id.historyTimer);
        Intent intent = getIntent();
        String tQ = intent.getStringExtra("totalQuestions");
        totalQuestions = Integer.parseInt(tQ);
        String tS = intent.getStringExtra("totalSeconds");
        totalSeconds = Integer.parseInt(tS);
        updateQuestion();

        reverseTimer(totalSeconds, timerText);

    }
    private void updateQuestion() {
        if(total > totalQuestions)
        {
            // opens result activity
            Intent intent = new Intent(HistoryQuiz.this, ResultActivity.class);
            intent.putExtra("total", String.valueOf(total - 1));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("incorrect", String.valueOf(wrong));
            correct = 0;
            total = 0;
            wrong = 0;
            /*
            Recursive calls, method stops once the total number of question is exceeded or time is reached maximum limit
            else it continues calling itself
             */
            startActivity(intent);
            finish();
        }
        else
        {
            /*

            Declaring a random number in the range of 0 and 40, because we set the maximum database size to 40.
            Randomized question to ensure trivial game mode
             */
            int min = 0, max = 40;
            int currentNumber = (int) (Math.random() * (max - min + 1));

            /*
            Getting connection from firebase db and setting the instance to reference object
             */
            reference = FirebaseDatabase.getInstance().getReference().child(String.valueOf(currentNumber));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final QuizQuestions quizQuestions = dataSnapshot.getValue(QuizQuestions.class);
                    intro_Question.setText(quizQuestions.getQuestion());
                    optionBtn1.setText(quizQuestions.getOption1());
                    optionBtn2.setText(quizQuestions.getOption2());
                    optionBtn3.setText(quizQuestions.getOption3());
                    optionBtn4.setText(quizQuestions.getOption4());


                    optionBtn1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            total++;
                            optionBtn1.setBackgroundColor(Color.GREEN);
                            if(optionBtn1.getText().toString().equals(quizQuestions.getAnswer())) {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        optionBtn1.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);

                            }
                            else {
                                wrong++;
                                optionBtn1.setBackgroundColor(Color.RED);
                                if(optionBtn2.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn2.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn3.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn3.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn4.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        optionBtn1.setBackgroundColor(Color.YELLOW);
                                        optionBtn2.setBackgroundColor(Color.YELLOW);
                                        optionBtn3.setBackgroundColor(Color.YELLOW);
                                        optionBtn4.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);
                            }

                          updateQuestion();
                        }
                    });


                    /*
                    When option 2 is selected, bellow code
                     */


                    optionBtn2.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            total++;
                            optionBtn2.setBackgroundColor(Color.GREEN);
                            if(optionBtn2.getText().toString().equals(quizQuestions.getAnswer())) {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        optionBtn2.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);

                            }
                            else {
                                wrong++;
                                optionBtn2.setBackgroundColor(Color.RED);
                                if(optionBtn1.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn1.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn3.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn3.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn4.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        optionBtn1.setBackgroundColor(Color.YELLOW);
                                        optionBtn2.setBackgroundColor(Color.YELLOW);
                                        optionBtn3.setBackgroundColor(Color.YELLOW);
                                        optionBtn4.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);
                            }

                            updateQuestion();
                        }
                    });


                    /*
                    When option 3 is selected, bellow code
                     */


                    optionBtn3.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            total++;
                            optionBtn3.setBackgroundColor(Color.GREEN);
                            if(optionBtn3.getText().toString().equals(quizQuestions.getAnswer())) {
                                Handler handler = new Handler();
                                handler.postDelayed(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        optionBtn3.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);

                            }
                            else {
                                wrong++;
                                optionBtn3.setBackgroundColor(Color.RED);
                                if(optionBtn2.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn2.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn1.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn1.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn4.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();

                                handler.postDelayed(
                                new Runnable() {
                                    @Override
                                    public void run() {

                                        optionBtn1.setBackgroundColor(Color.YELLOW);
                                        optionBtn2.setBackgroundColor(Color.YELLOW);
                                        optionBtn3.setBackgroundColor(Color.YELLOW);
                                        optionBtn4.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);
                            }

                            updateQuestion();
                        }
                    });





                 /*
                 When option4 is selected, bellow code

                  */

                    optionBtn4.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            total++;
                            optionBtn4.setBackgroundColor(Color.GREEN);
                            if(optionBtn4.getText().toString().equals(quizQuestions.getAnswer())) {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        optionBtn4.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);

                            }
                            else {
                                wrong++;
                                optionBtn4.setBackgroundColor(Color.RED);
                                if(optionBtn2.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn2.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn3.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn3.setBackgroundColor(Color.GREEN);
                                }
                                else if(optionBtn1.getText().toString().equals(quizQuestions.getAnswer())){
                                    optionBtn1.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        optionBtn1.setBackgroundColor(Color.YELLOW);
                                        optionBtn2.setBackgroundColor(Color.YELLOW);
                                        optionBtn3.setBackgroundColor(Color.YELLOW);
                                        optionBtn4.setBackgroundColor(Color.YELLOW);
                                    }
                                }, 500);
                            }

                            updateQuestion();
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }

    /*
    Bellow method does the following things:
    1. Counts and manages time using a countdowntimer
     2. launches result activity when the game is finished

     */
    public void reverseTimer(int Seconds, final TextView textView) {
        new CountDownTimer(Seconds * 1000 + 1000, 1000){
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds %= 60;
                textView.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }
            public void onFinish() {
                textView.setText("Completed");
                Intent intent = new Intent(HistoryQuiz.this, ResultActivity.class);

                intent.putExtra("correct", String.valueOf(correct));
                intent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(intent);
                finish();
            }
        }.start();
    }

    /*

    back button event handling
     */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(HistoryQuiz.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Go back to main menu")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnBtn = new Intent(HistoryQuiz.this, MainActivity.class);
                        startActivity(returnBtn);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }
}
