package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button3);
        TextView textview = findViewById(R.id.textView);
        Random rand = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rand_int1 = rand.nextInt(1000);

                textview.setText(Integer.toString(rand_int1));
            }
        });
    }

}