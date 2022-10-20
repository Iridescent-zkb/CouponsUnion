package com.example.couponsunion.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import com.example.couponsunion.R;
import com.example.couponsunion.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends Activity {

    @BindView(R.id.test_navigation_bar)
    public RadioGroup navigationBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        navigationBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                LogUtils.d(TestActivity.class,"checkedId --> " + checkedId);
                switch (checkedId){
                    case R.id.test_home:
                        LogUtils.d(TestActivity.class,"切换到首页");
                        break;
                    case R.id.test_selected:
                        LogUtils.d(TestActivity.class,"切换到精选");
                        break;
                    case R.id.test_red_packet:
                        LogUtils.d(TestActivity.class,"切换到特惠");
                        break;
                    case R.id.test_search:
                        LogUtils.d(TestActivity.class,"切换到搜索");
                        break;
                }
            }
        });
    }
}
