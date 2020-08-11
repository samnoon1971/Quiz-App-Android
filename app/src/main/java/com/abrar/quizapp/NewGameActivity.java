package com.abrar.quizapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewGameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        Toast.makeText(getApplicationContext(), "New game started", Toast.LENGTH_SHORT).show();
        
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
    }
    public void callExitMenu() {


        Toast.makeText(this, "Exit menu is called.", Toast.LENGTH_LONG).show();
    }
}
