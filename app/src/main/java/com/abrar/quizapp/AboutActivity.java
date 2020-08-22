package com.abrar.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    /*
    declaring textview and buttons

     */
    private TextView title_tv, dev1_tv, dev2_tv, dev3_tv, dev4_tv;
    private Button back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_game);
        title_tv = (TextView) findViewById(R.id.about_devtitle_tv);
        dev1_tv = (TextView) findViewById(R.id.about_dev1_tv);
        dev2_tv = (TextView) findViewById(R.id.about_dev2_tv);
        dev3_tv = (TextView) findViewById(R.id.about_dev3_tv);
        dev4_tv = (TextView) findViewById(R.id.about_dev4_tv);
        back_btn = (Button) findViewById(R.id.back_from_settings_tv);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Back Button Selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(AboutActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Go back to main menu")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent returnBtn = new Intent(AboutActivity.this, MainActivity.class);
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
        new AlertDialog.Builder(AboutActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Go back to main menu")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnBtn = new Intent(AboutActivity.this, MainActivity.class);
                        startActivity(returnBtn);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
