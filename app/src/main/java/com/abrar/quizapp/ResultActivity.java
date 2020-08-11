package com.abrar.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView4);
        t3 = (TextView) findViewById(R.id.textView6);
        Intent i = getIntent();

        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");
        int total = Integer.valueOf(correct) + Integer.valueOf(wrong);
        String questions = String.valueOf(total);
        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(ResultActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Go back to main menu")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnBtn = new Intent(ResultActivity.this, MainActivity.class);
                        startActivity(returnBtn);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
