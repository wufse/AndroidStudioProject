package com.example.daemon.gps;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private Button btn_one;
    private Button btn_two;
    private Button btn_three;

    private TextView tv_res;
    private LocationManager lm;
    private List<String> pName=new ArrayList<string>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        bindViews();
    }

    public void bindViews() {
        btn_one=(Button)findViewById(R.id.btn_one);
        btn_two=(Button)findViewById(R.id.btn_two);
        btn_three=(Button)findViewById(R.id.btn_three);

        tv_res=(TextView)findViewById(R.id.tv_res);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
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
