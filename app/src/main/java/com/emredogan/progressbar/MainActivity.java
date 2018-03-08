package com.emredogan.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ProgressBar progressBar2;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_id);
        progressBar2 = (ProgressBar) findViewById(R.id.progress_id2);
        progressBar.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);

        progressBar2.setProgress(0);
        progressBar2.setSecondaryProgress(0);
        progressBar2.setMax(100);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                if(++i<=100) {

                    progressBar2.setProgress(i);
                    progressBar2.setSecondaryProgress(i+10);

                } else {

                    timer.cancel();

                }



            }
        };

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);


            }
        },8000,250);
    }
}
