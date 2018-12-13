package com.example.daemon.helloworld;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.daemon.hardlibrary.HardControl;

import android.support.v4.app.FragmentActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Button button=null;
    private boolean ledon=false;
    private CheckBox checkboxled1=null;
    private CheckBox checkboxled2=null;
    private CheckBox checkboxled3=null;
    private CheckBox checkboxled4=null;
    private TextView textview=null;

    //sensor
    private Sensor mSensor;
    private SensorManager mSensorManager;
    List<Sensor> sensorList;

    private Vibrator vibrator=null;

    //vibartor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button=(Button) findViewById(R.id.BUTTON);
        checkboxled1=(CheckBox) findViewById(R.id.LED1);
        checkboxled2=(CheckBox) findViewById(R.id.LED2);
        checkboxled3=(CheckBox) findViewById(R.id.LED3);
        checkboxled4=(CheckBox) findViewById(R.id.LED4);
        textview=(TextView) findViewById(R.id.Text1);

        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

       // HardControl hardControl=new HardControl();

       // hardControl.ledOpen();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                vibrator.vibrate(1000);
                // Perform action on click
                ledon=!ledon;
                if(ledon){
                    button.setText("ALL OFF");
                    checkboxled1.setChecked(true);
                    checkboxled2.setChecked(true);
                    checkboxled3.setChecked(true);
                    checkboxled4.setChecked(true);
                }
                else {
                    button.setText("ALL ON");
                    checkboxled1.setChecked(false);
                    checkboxled2.setChecked(false);
                    checkboxled3.setChecked(false);
                    checkboxled4.setChecked(false);
                }
            }
        });
    }


    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            float X_lateral=sensorEvent.values[0];
            textview.setText(X_lateral+"");

        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED1 OFF",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.LED2:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED2 ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED2 OFF",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.LED3:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED3 OFF",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.LED4:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED4 ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED4 OFF",Toast.LENGTH_SHORT).show();
                }
                break;
            // TODO: Veggie sandwich
        }
    }


  //  protected void Onresume()
  //  {
   //     super.onResume();
        //register listener
    //    mSensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_GAME);
   // }



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
