package com.company.myapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.company.myapp.R;
import com.company.myapp.fragment.TopBaseFragment;
import com.company.myapp.fragment.TopFavorite2Fragment;
import com.company.myapp.fragment.TopFavoriteFragment;
import com.company.myapp.fragment.TopMovieFragment;
import com.company.myapp.fragment.TopNewsFragment;
import com.company.myapp.fragment.TopRankingFragment;
import com.company.myapp.fragment.TopTopFragment;

public class HomeActivity extends BaseActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks , TopBaseFragment.OnFragmentInteractionListener{

    private DrawerLayout mDrawerLayout;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    private ViewPager mViewpager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        if(false) {
            Intent intent = new Intent(this, AppIntroActivity.class);
            startActivity(intent);
        }

        findviews();
        setUp();
    }

    private void findviews(){
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager_top);
        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
    }

    private void setUp() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

        TopPagerAdapter adapter = new TopPagerAdapter(getSupportFragmentManager(), HomeActivity.this);
        mViewpager.setAdapter(adapter);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position < 3){
                    mTabLayout.setTabTextColors(getResources().getColor(R.color.gray_500), getResources().getColor(R.color.pink_300));
                    mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.pink_300));
                } else {
                    mTabLayout.setTabTextColors(getResources().getColor(R.color.gray_500), getResources().getColor(R.color.green_300));
                    mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.green_300));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewpager);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
//        // update the main content by replacing fragments
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.home, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
        }
    }

    public class TopPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[]{"トップ","お気に入り","ランキング","ニュース","動画","お気に入り"};

        public TopPagerAdapter(FragmentManager fm, Context context){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TopTopFragment.newInstance("","");
                case 1:
                    return TopFavoriteFragment.newInstance("","");
                case 2:
                    return TopRankingFragment.newInstance("","");
                case 3:
                    return TopNewsFragment.newInstance("","");
                case 4:
                    return TopMovieFragment.newInstance("","");
                case 5:
                    return TopFavorite2Fragment.newInstance("","");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return new SpannableString(tabTitles[position]);
        }
    }

}
