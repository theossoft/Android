package com.example.headfirst_stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import java.util.Locale;
import android.os.Handler;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    //Количество секунд на секундомере.
    private int seconds = 0;
    //Секундомер работает?
    private boolean running;
    //В переменной wasRunning хранится информация о том, работал ли секундомер перед вызовом метода onStop().
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        //Получить предыдущее состояние секундомера, если активность была уничтожена и создана заново. Состояние активности восстанавливается по значениям, прочитанным из Bundle
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            //Восстановить состояние переменной wasRunning, если активность создается заново.
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }
    //Сохранить состояние секундомера, если он готовится к уничтожению. Состояние переменных сохраняется в методе onSaveInstanceState() активности
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState); //Это добавила идея, в книге этого нет
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        //Сохранить состояние переменной wasRunning.
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    //Сохранить информацию о том, работал ли секундомер на момент вызова метода onStop().
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    //Реализация метода onStart(). Если секундомер работал, то отсчет времени возобновляется.
    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    //Запустить секундомер при щелчке на кнопке Start.
    public void onClickStart(View view) {
        running = true;
    }
    //Остановить секундомер при щелчке на кнопке Stop.
    public void onClickStop(View view) {
        running = false;
    }

    //Сбросить секундомер при щелчке на кнопке Reset.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }
    //Обновление показаний таймера. Метод runTimer() использует объект Handler для увеличения числа секунд и обновления надписи.
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}