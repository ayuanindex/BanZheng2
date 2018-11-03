package com.ayuan.banzheng2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    private IService iService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, DemmoService.class);
        MyConnection myConnection = new MyConnection();
        boolean b = bindService(intent, myConnection, BIND_AUTO_CREATE);
        if (b) {
            Toast.makeText(this, "服务已经开启", Toast.LENGTH_SHORT).show();
        }
        Button button = (Button) findViewById(R.id.btn);
        //点击按钮调用服务中打麻将的方法
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iService != null) {
                    iService.callBanZheng(10000);
                    iService.callPlayMaJiang();
                }
            }
        });
    }

    public class MyConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iService = (IService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
