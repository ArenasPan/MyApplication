package com.example.user.drawerlayoutactionbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private ActionBar mActionBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //取得ActionBar
        mActionBar = getSupportActionBar();
        //设置不显示标题
        mActionBar.setDisplayShowTitleEnabled(false);
        //设置显示logo
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setDisplayUseLogoEnabled(true);
        mActionBar.setLogo(R.drawable.netease_top);
        //设置actionbar背景
        Drawable background = getResources().getDrawable(R.drawable.top_bar_background);
        mActionBar.setBackgroundDrawable(background);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        //设置DrawerLayout监听事件
        mDrawerLayout.setDrawerListener(new MyDrawerListener());
        this.mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.drawer_open, R.string.drawer_close);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
    **onPostCreate需选择只有Bundle一个参数的函数来重写，否则不显示三横图标
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }


    private class MyDrawerListener implements DrawerLayout.DrawerListener {

        @Override
        public void onDrawerSlide(View view, float v) {
            mActionBarDrawerToggle.onDrawerSlide(view, v);
        }

        @Override
        public void onDrawerOpened(View view) {
            mActionBarDrawerToggle.onDrawerOpened(view);
        }

        @Override
        public void onDrawerClosed(View view) {
            mActionBarDrawerToggle.onDrawerClosed(view);
        }

        @Override
        public void onDrawerStateChanged(int i) {
            mActionBarDrawerToggle.onDrawerStateChanged(i);
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
//                mDrawerLayout.closeDrawers();
//                return true;
//            }
//        }
//        if (keyCode == KeyEvent.KEYCODE_MENU) {
//            if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
//                mDrawerLayout.closeDrawers();
//                return true;
//            }else {
//                mDrawerLayout.openDrawer(Gravity.START);
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
     //   int id = item.getItemId();

        //点击三横线会弹出DrawerLayout,反之会收起
        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
