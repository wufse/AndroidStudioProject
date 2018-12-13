package com.example.daemon.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


//sensor
import  android.hardware.Sensor;
import  android.hardware.SensorEvent;
import  android.hardware.SensorEventListener;
import  android.hardware.SensorManager;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private String TAG=this.getClass().getSimpleName();

    private Sensor senor;
    private SensorManager sm;
    private TextView sensor_text,tv_text;

    private float x,y,z;
    private String res="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("hehehehehe", "******************oncreate********************");

        sensor_text=(TextView)findViewById(R.id.demo_sensor);
        tv_text=(TextView)findViewById(R.id.tv);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        senor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //list
        List<Sensor> list=sm.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor:list)
        {
            tv_text.append(sensor.getName()+'\n');
        }

        //create  listen

        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                x=event.values[SensorManager.DATA_X];
                y=event.values[SensorManager.DATA_Y];
                z=event.values[SensorManager.DATA_Z];
                res="x: "+x+",y: "+y+",z: "+z;
               // res="light: "+event.values[0];
                sensor_text.setText(res);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sm.registerListener(sel,senor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onStart()
    {
        super.onStart();
        Log.w(TAG,"onStart");
    }
    public void onRestart()
    {
        super.onRestart();
        Log.w(TAG, "onRestart");
    }

    public void onResume()
    {
        super.onResume();
        Log.w(TAG, "onResume");
    }

    public void onPause()
    {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    public void onStop()
    {
        super.onStop();
        Log.w(TAG, "onStop");
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.w(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
