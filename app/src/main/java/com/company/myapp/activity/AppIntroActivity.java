package com.company.myapp.activity;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.myapp.R;
import com.company.myapp.fragment.AppIntro1Fragment;
import com.company.myapp.fragment.AppIntro2Fragment;
import com.company.myapp.fragment.AppIntro3Fragment;
import com.company.myapp.fragment.AppIntroLastFragment;
import com.company.myapp.fragment.BaseFragment;

public class AppIntroActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private Button mBtnNext;
    private LinearLayout mPagerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro_acitvity);

        findviews();
        init();
    }

    private void init() {
        FragmentManager manager = getSupportFragmentManager();
        mViewPager.setAdapter(new AppIntroPagerAdapter(manager));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 3) {
                    mBtnNext.setVisibility(View.GONE);
                } else {
                    mBtnNext.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    mBtnNext.setVisibility(View.GONE);
                } else {
                    mBtnNext.setVisibility(View.VISIBLE);
                }
                setPagerIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
            }

        });

        setPagerIndex(0);
    }

    private void findviews() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager_appintro);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mPagerIndex = (LinearLayout) findViewById(R.id.layout_pagerIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_intro_acitvity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClickLogin() {
        finish();
    }

    public class AppIntroPagerAdapter extends FragmentPagerAdapter {
        public AppIntroPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return AppIntro1Fragment.newInstance("","");
                case 1:
                    return AppIntro2Fragment.newInstance("","");
                case 2:
                    return AppIntro3Fragment.newInstance("","");
                case 3:
                    return AppIntroLastFragment.newInstance("","");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    private void setPagerIndex(int position) {
        mPagerIndex.removeAllViews();
        for (int i = 0 ; i < 4; i++ ){
            TextView mtext = new TextView(this);
            mtext.setText("●");
            if(i == position) {
                mtext.setTextColor(Color.WHITE);
            } else {
                mtext.setTextColor(Color.GRAY);
            }
            mtext.setTextSize(10f);
            LinearLayout.LayoutParams param =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            param.setMargins(5,0,5,0);
            mPagerIndex.addView(mtext, param);
        }
    }
}
