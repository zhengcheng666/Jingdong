package com.example.jingdong;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jingdong.Fragment.HomeFragment;
import com.example.jingdong.Fragment.LessFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton bt1;
    private RadioButton bt2;
    private RadioButton bt3;
    private RadioButton bt4;
    private RadioButton bt5;
    private FrameLayout fl;
    private LinearLayout xian;
    private HomeFragment homeFragment;
    private LessFragment lessFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt1 = (RadioButton) findViewById(R.id.bt_1);
        bt2 = (RadioButton) findViewById(R.id.bt_2);
        bt3 = (RadioButton) findViewById(R.id.bt_3);
        bt4 = (RadioButton) findViewById(R.id.bt_4);
        bt5 = (RadioButton) findViewById(R.id.bt_5);
        fl = (FrameLayout) findViewById(R.id.fl);
        xian = (LinearLayout) findViewById(R.id.xian);
        homeFragment = new HomeFragment();
        lessFragment = new LessFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl,homeFragment)
                .add(R.id.fl,lessFragment)
                .show(homeFragment)
                .hide(lessFragment)
                .commit();

        //按钮的监听
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                getSupportFragmentManager().beginTransaction()
                        .show(homeFragment)
                        .hide(lessFragment)
                        .commit();
                break;
            case R.id.bt_2:
                getSupportFragmentManager().beginTransaction()
                        .show(lessFragment)
                        .hide(homeFragment)
                        .commit();
                break;
            case R.id.bt_3:
                break;
            case R.id.bt_4:
                break;
            case R.id.bt_5:
                break;
        }
    }
}