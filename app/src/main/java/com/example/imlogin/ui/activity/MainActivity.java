package com.example.imlogin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.imlogin.R;
import com.example.imlogin.ui.fragments.ContactsFragment;
import com.example.imlogin.ui.fragments.ConversationFragment;
import com.example.imlogin.ui.fragments.DiscoveryFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.close, R.string.open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        fragments = new ArrayList<>();
        fragments.add(new ConversationFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DiscoveryFragment());

        titles = new ArrayList<>();
        titles.add(getResources().getString(R.string.conversation));
        titles.add(getResources().getString(R.string.contacts));
        titles.add(getResources().getString(R.string.discovery));

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_zhihu:

                        break;
                    case R.id.menu_wechat:

                        break;
                    case R.id.menu_group:

                        break;
                    case R.id.menu_map:
                        startActivity(new Intent(MainActivity.this, MapActivity.class));
                        break;
                    case R.id.menu_navi:
                        startActivity(new Intent(MainActivity.this,NaviActivity.class));
                        break;

                }
                return false;
            }
        });

    }


}
