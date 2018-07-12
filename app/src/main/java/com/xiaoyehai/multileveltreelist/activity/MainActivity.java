package com.xiaoyehai.multileveltreelist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xiaoyehai.multileveltreelist.R;

/**
 * Android多级树形列表
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.btn_listview: //使用ListView实现
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.btn_recycleview: //使用RecycleView实现
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
        }
    }
}
