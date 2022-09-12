package com.example.couponsunion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.couponsunion.R;
import com.example.couponsunion.base.BaseFragment;
import com.example.couponsunion.ui.fragment.HomeFragment;
import com.example.couponsunion.ui.fragment.RedPacketFragment;
import com.example.couponsunion.ui.fragment.SearchFragment;
import com.example.couponsunion.ui.fragment.SelectedFragment;
import com.example.couponsunion.utils.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.nio.Buffer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView  mNavigationView;
    private HomeFragment mHomeFragment;
    private RedPacketFragment mRedPacketFragment;
    private SelectedFragment mSelectedFragment;
    private SearchFragment mSearchFragment;
    private FragmentManager mFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragments();
        initListener();
    }

    private void initFragments() {
        mHomeFragment = new HomeFragment();
        mRedPacketFragment = new RedPacketFragment();
        mSelectedFragment = new SelectedFragment();
        mSearchFragment = new SearchFragment();
        mFm = getSupportFragmentManager();
        switchFragment(mHomeFragment);
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(item -> {
//                Log.d(TAG,"title -->" + item.getTitle() + "id --> " + item.getItemId());
            if (item.getItemId() == R.id.home){
                LogUtils.d(MainActivity.class,"切换到首页");
                switchFragment(mHomeFragment);
            }else if (item.getItemId() == R.id.selected){
                LogUtils.i(MainActivity.class,"切换到精选");
                switchFragment(mRedPacketFragment);
            }else if (item.getItemId() == R.id.red_packet){
                LogUtils.w(MainActivity.class,"切换到特惠");
                switchFragment(mSelectedFragment);
            }else if (item.getItemId() == R.id.search){
                LogUtils.e(MainActivity.class,"切换到搜索");
                switchFragment(mSearchFragment);
            }
            return true;
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container,targetFragment);
        fragmentTransaction.commit();
    }


}