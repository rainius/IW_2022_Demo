package com.dmtech.iw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.dmtech.iw.databinding.MainDrawerLayoutBinding;

public class MainActivity extends AppCompatActivity {

    //视图绑定对象
    private MainDrawerLayoutBinding mBinding;
    //抽屉按钮
    private ActionBarDrawerToggle mDawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //导入视图绑定对象
        mBinding = MainDrawerLayoutBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
//        setContentView(R.layout.main_drawer_layout);
        //将Toolbar设定为ActionBar
        setSupportActionBar(mBinding.mainView.mainToolbar);
        //建立抽屉按钮实例
        mDawerToggle = new ActionBarDrawerToggle(
                this,
                mBinding.drawer,
                mBinding.mainView.mainToolbar,
                R.string.open,
                R.string.close
        );
        mBinding.drawer.addDrawerListener(mDawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDawerToggle.syncState();
    }
}