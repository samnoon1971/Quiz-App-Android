package com.abrar.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button newGame, about, exit;
    private ImageView imageView;
    Handler handler;
    private static int SPLASH_TIMEOUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



         /*
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);


          */
        setContentView(R.layout.activity_main);
        newGame = (Button) findViewById(R.id.new_game_tv);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "New Game Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        about = (Button) findViewById(R.id.about_tv);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "About selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        exit = (Button) findViewById(R.id.exit_tv);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callExitMenu();
            }
        });
        imageView = (ImageView) findViewById(R.id.qicon);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.first_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_menu:
                callAboutMenu();
                break;
            case R.id.exit_menu:
                callExitMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void callAboutMenu() {
        Toast.makeText(this, "About menu is called.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
        finish();
    }
    public void callExitMenu() {


        Toast.makeText(this, "Exit menu is called.", Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Exit menu is called.", Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
