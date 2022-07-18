package com.example.ihc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView view_x, view_y, view_z, view_light, view_temperature;
    private float x, y, z, last_x, last_y, last_z;
    private Sensor accelerometer, light_sensor, thermometer;
    private Button getGPSBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        view_x = (TextView) findViewById(R.id.view_x);
        view_y = (TextView) findViewById(R.id.view_y);
        view_z = (TextView) findViewById(R.id.view_z);
        view_light = (TextView) findViewById(R.id.view_light);
        view_temperature = (TextView) findViewById(R.id.view_temperature);

        if ((accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)) != null){
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if ((light_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)) != null){
            sensorManager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if ((thermometer = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)) != null){
            sensorManager.registerListener(this, thermometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

            if(Math.abs(x - last_x) > 2 || Math.abs(x - last_x) > 2 || Math.abs(x - last_x) > 2){
                // Send();
            }
            view_x.setText("X: " + x);
            view_y.setText("Y: " + y);
            view_z.setText("Z: " + z);
        } else if (sensor.getType() == Sensor.TYPE_LIGHT) {
            view_light.setText("Iluminação: " + event.values[0]);
        } else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            view_temperature.setText("Temperatura: " + event.values[0] + " ºC");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void Send()
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}