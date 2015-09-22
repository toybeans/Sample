package com.company.myapp.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import com.company.myapp.R;
import com.company.myapp.fragment.BaseFragment;
import com.company.myapp.fragment.SearchArtistFragment;
import com.company.myapp.fragment.SearchBaseFragment;
import com.company.myapp.fragment.SearchUnitFragment;

public class SearchActivity extends AppCompatActivity implements SearchBaseFragment.OnFragmentInteractionListener {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findviews();
        setUp();
    }

    private void findviews() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_serch);
        mTabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
    }

    private void setUp() {
        SearchPagerAdapter adapter = new SearchPagerAdapter(getSupportFragmentManager(), SearchActivity.this);
        mViewPager.setAdapter(adapter);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(SearchActivity.this);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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

    public class SearchPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[]{"ユニット","アーティスト"};
        Context mContext;
        public SearchPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return SearchUnitFragment.newInstance("","");
                case 1:
                    return SearchArtistFragment.newInstance("","");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  new SpannableString(tabTitles[position]);
        }
    }
}
