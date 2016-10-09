package com.examples.rehan.rehan.Activities.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.examples.rehan.rehan.Activities.Fragments.Viewpager1;
import com.examples.rehan.rehan.Activities.Fragments.Viewpager2;
import com.examples.rehan.rehan.Activities.Fragments.Viewpager3;
import com.examples.rehan.rehan.Activities.Fragments.Viewpager4;
import com.examples.rehan.rehan.R;
import com.sembozdemir.viewpagerarrowindicator.library.ViewPagerArrowIndicator;

import it.sephiroth.android.library.bottomnavigation.BadgeProvider;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerArrowIndicator viewPagerArrowIndicator;
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    ImageView hamburgerIV;
    TextView transferTV,rupeedTV,addmoneyTV;
    RelativeLayout toolbarRL;
    boolean visible = true;
    TabLayout tabLayout;
    TabItem rechargeTI,shopTI,offerTI,walletTI,nearbyTI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerArrowIndicator = (ViewPagerArrowIndicator) findViewById(R.id.viewPagerArrowIndicator);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        viewPagerArrowIndicator.bind(viewPager);
        toolbarRL = (RelativeLayout)findViewById(R.id.toolbar);
        hamburgerIV = (ImageView)findViewById(R.id.hamburger);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationview = (NavigationView)findViewById(R.id.navigation_drawer);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        shopTI = (TabItem)findViewById(R.id.shop);
        hamburgerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.END)){
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intent = new Intent(MainActivity.this,ShopActivity.class);
                        intent.putExtra("TABNAME",tab.getText().toString());
                        //Bundle bundle = ActivityOptions.makeCustomAnimation(MainActivity.this,
                        //        R.xml.anim1,R.xml.anim2).toBundle();
                        startActivity(intent);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        final View view = navigationview.getHeaderView(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visible) {
                    navigationview.getMenu().setGroupVisible(R.id.secondary, false);
                    visible = false;
                }
                else{
                    navigationview.getMenu().setGroupVisible(R.id.secondary, true);
                    visible = true;
                }
                Menu menu = navigationview.getMenu();
                MenuItem menuItem = menu.findItem(R.id.notifications);
                View vi = menuItem.getActionView();
                ViewCompat.animate(vi)
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .setInterpolator(new Interpolator() {
                            private final float mCycles = 0.5f;
                            @Override
                            public float getInterpolation(float input) {
                                return (float) Math.sin(2.0f * mCycles * Math.PI * input);
                            }
                        })
                        .setListener(new ViewPropertyAnimatorListener() {
                            @Override
                            public void onAnimationStart(View view) {

                            }

                            @Override
                            public void onAnimationEnd(View view) {

                            }

                            @Override
                            public void onAnimationCancel(View view) {

                            }
                        }).withLayer().start();
            }
        });
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){

                    case R.id.mywallet:
                        Fragment fragment = new Viewpager1();
                        FragmentManager fragmentmanager = getSupportFragmentManager();
                        fragmentmanager.beginTransaction().replace(R.id.main_content,fragment).commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;


                }

                return true;
            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0:
                    return new Viewpager1();
                case 1:
                    return new Viewpager2();
                case 2:
                    return new Viewpager3();
                case 3:
                    return new Viewpager4();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        finish();
    }
}
