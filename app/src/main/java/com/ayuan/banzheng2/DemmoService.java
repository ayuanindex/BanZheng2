package com.ayuan.banzheng2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class DemmoService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //办证的方法
    public void banZheng(int money) {
        if (1000 < money) {
            Toast.makeText(this, "明天过来拿证", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "拿个" + money + "块钱还想办证？滚犊子", Toast.LENGTH_SHORT).show();
        }
    }

    //打麻将的方法
    public void playMaJiang() {
        Toast.makeText(this, "陪领导打麻将", Toast.LENGTH_SHORT).show();
    }

    //洗桑拿的方法
    public void xiSangNa() {
        Toast.makeText(this, "陪领导洗桑拿", Toast.LENGTH_SHORT).show();
    }

    private class MyBinder extends Binder implements IService {

        public void callPlayMaJiang() {
            //调用打麻将的方法
            playMaJiang();
        }

        public void callXiSangNa() {
            //调用洗桑拿的方法
            xiSangNa();
        }

        @Override
        public void callBanZheng(int money) {
            //调用办证的方法
            banZheng(money);
        }
    }
}
