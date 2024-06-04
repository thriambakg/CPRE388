package com.example.lab7;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    private TextView stepCountTextView;
    private Button resetButton;

    private int stepCount = 0;
    private boolean isPeak = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepCountTextView = findViewById(R.id.stepCountTextView);
        resetButton = findViewById(R.id.resetButton);

        // Initialize the SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Check if the accelerometer sensor is available
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometerSensor == null) {
            // Handle the case when the accelerometer sensor is not available on the device
            stepCountTextView.setText("Accelerometer sensor not available");
        }

        // Set up the reset button click listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetStepCount();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the sensor listener when the activity is resumed
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor listener when the activity is paused
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Detect peaks in the accelerometer data to estimate steps
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        float acceleration = (float) Math.sqrt(x * x + y * y + z * z);

        if (isPeak(acceleration)) {
            stepCount++;
            isPeak = false; // Reset peak flag after detecting a step
            stepCountTextView.setText("Steps: " + stepCount);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle accuracy changes if needed
    }

    private boolean isPeak(float currentValue) {
        // Simple peak detection logic
        if (currentValue > 9.81 && !isPeak) {
            isPeak = true;
            return true;
        }
        return false;
    }

    private void resetStepCount() {
        // Reset the step count to zero
        stepCount = 0;
        stepCountTextView.setText("Steps: " + stepCount);
    }
}


