package com.longc.shoppingmall.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.longc.shoppingmall.R;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //两秒后进入主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //主线程
                //启动主页面
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                //关闭welcomeactivity页面
                finish();
            }
        }, 2000);
    }
}
