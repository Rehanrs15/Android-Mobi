package com.examples.rehan.rehan.Activities.Activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.examples.rehan.rehan.R;


public class SplashActivity extends AppCompatActivity {

    private static int OPEN_MAIN_ACTIVITY_RESULT = 0;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        timer();
    }

    private void timer() {
        new CountDownTimer(1000,5000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivityForResult(new Intent(SplashActivity.this,MainActivity.class),OPEN_MAIN_ACTIVITY_RESULT);
            }
        }.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == OPEN_MAIN_ACTIVITY_RESULT && resultCode == RESULT_OK){
            finish();
        }
    }
}
