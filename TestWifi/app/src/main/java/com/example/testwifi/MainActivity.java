package com.example.testwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{
    private WifiManager wifiManager;
    Switch wifi;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifi = findViewById(R.id.idSwitch);
        btn = findViewById(R.id.idBtn);
        wifi.setChecked(true);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!wifi.isChecked())
                {
                    //wifiManager.setTdlsEnabled();
            }
        });
    }
}
