package com.abrar.quizapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.*;

public class AddFirebaseEntry extends AppCompatActivity {
    private EditText question, answer, option1, option2, option3, option4;
    Button buttonAdd;
    public DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedBundleState) {
        super.onCreate(savedBundleState);
        setContentView(R.layout.db_add);
        databaseReference = FirebaseDatabase.getInstance().getReference("history");
        question = (EditText) findViewById(R.id.editTextTextPersonName);
        answer = (EditText) findViewById(R.id.editTextTextPersonName2);
        option1 = (EditText) findViewById(R.id.editTextTextPersonName3);
        option2 = (EditText) findViewById(R.id.editTextTextPersonName4);
        option3 = (EditText) findViewById(R.id.editTextTextPersonName5);
        option4 = (EditText) findViewById(R.id.editTextTextPersonName6);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHistoryQuiz();
            }
        });

    }

    private void addHistoryQuiz() {
        String Question = question.getText().toString();
        String Answer = answer.getText().toString();
        String Option1 = option1.getText().toString();
        String Option2 = option2.getText().toString();
        String Option3 = option3.getText().toString();
        String Option4 = option4.getText().toString();
        if(!TextUtils.isEmpty(Question)) {
            String id = databaseReference.push().getKey();
            QuizQuestions newQuiz = new QuizQuestions(Question, Answer, Option1, Option2, Option3, Option4);
            databaseReference.child(id).setValue(newQuiz);
        } else {
            Toast.makeText(getApplicationContext(), "Empty text, enter data", Toast.LENGTH_SHORT).show();
        }

     }
}
