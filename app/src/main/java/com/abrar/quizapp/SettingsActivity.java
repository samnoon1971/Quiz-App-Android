package com.abrar.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private EditText quesEdit, secEdit;
    private TextView NoOfQues, NoOfSec;
    private Button Save, Back;
    public int totalQuestions, totalSeconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        totalQuestions = 5;
        totalSeconds = 60;

        quesEdit = (EditText) findViewById(R.id.editTextQues);
        secEdit =  (EditText) findViewById(R.id.editTextSeconds);
        quesEdit.setInputType(InputType.TYPE_CLASS_NUMBER);
        secEdit.setInputType(InputType.TYPE_CLASS_NUMBER);
        NoOfQues = (TextView) findViewById(R.id.id_no_ofQues);
        NoOfSec = (TextView) findViewById(R.id.id_no_ofSeconds);

        Save = (Button) findViewById(R.id.save_changesBtn);
        Back = (Button) findViewById(R.id.backBtnSettings);

        quesEdit.setText(String.valueOf(totalQuestions));
        secEdit.setText(String.valueOf(totalSeconds));

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalQuestions = Integer.parseInt(String.valueOf(quesEdit.getText()));
                totalSeconds = Integer.parseInt(String.valueOf(secEdit.getText()));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SettingsActivity.this, HistoryQuiz.class);
                intent.putExtra("totalQuestions", String.valueOf(totalQuestions));
                intent.putExtra("totalSeconds", String.valueOf(totalSeconds));
                startActivity(intent);
                finish();



            }


        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(SettingsActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Go back to main menu")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent returnBtn = new Intent(SettingsActivity.this, MainActivity.class);
                                startActivity(returnBtn);
                                finish();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(SettingsActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Go back to main menu")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnBtn = new Intent(SettingsActivity.this, MainActivity.class);
                        startActivity(returnBtn);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
