package com.example.a0101_crowgager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mCrowsCounterButton;
    private int mCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCrowsCounterButton = findViewById(R.id.buttonCrowsCounter);
        TextView tvHello = (TextView)findViewById(R.id.textView);
        mCrowsCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHello.setText("Я насчитал " + ++mCount + " ворон");
            }
        });

    }

    public void butHello_Click(View v){
        TextView tvHello = (TextView)findViewById(R.id.textView);
        // выводим текст в TextView
        tvHello.setText("Ты кто такой? Давай, до свидания!");
    }



}