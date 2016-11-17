package com.cndatacom.flowdocument.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.activity.personal.MainPersonalActivity;
import com.cndatacom.flowdocument.service.HeartBeatService;
import com.cndatacom.flowdocument.utils.Network;
import com.cndatacom.flowdocument.utils.Network.NetWorkType;
import com.cndatacom.flowdocument.utils.TelephoneUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_personal_user;//personal user
    private ImageButton btn_enterprise_user;//enterprise user
    private String ip = "";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, ip, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        getMessage();
//        initService();
        initWifi();
    }

    private void initWifi() {
        NetWorkType type = Network.getNetworkType(this);
        switch (type) {
            case UnKnown:
                Toast.makeText(this, "Unknown", Toast.LENGTH_LONG).show();
                break;
            case Wifi:
                Toast.makeText(this, "Wifi", Toast.LENGTH_LONG).show();
                break;
            case Net2G:
                Toast.makeText(this, "2G", Toast.LENGTH_LONG).show();
                break;
            case Net3G:
                Toast.makeText(this, "3G", Toast.LENGTH_LONG).show();
                break;
            case Net4G:
                Toast.makeText(this, "4G", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void initService() {
        startService(new Intent(this, HeartBeatService.class));
    }

    private void getMessage() {
        Toast.makeText(this, TelephoneUtil.getLocalIpAddress(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, TelephoneUtil.getIMSI(this), Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ip = TelephoneUtil.GetNetIp();
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    private void initView() {
        btn_personal_user = (ImageButton) findViewById(R.id.btn_personal_user);
        btn_enterprise_user = (ImageButton) findViewById(R.id.btn_enterprise_user);

        btn_personal_user.setOnClickListener(this);
        btn_enterprise_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_personal_user:
                //go to the MainPersonalActivity
                intent.setClass(MainActivity.this, MainPersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_enterprise_user:
                break;
        }
    }
}
