package com.example.mykino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy{

    FloatingActionButton fab;
    TabLayout tabLayout;


    ArrayList<String> titles;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        tabLayout = findViewById(R.id.tabLayout);


        ViewPager viewPager = findViewById(R.id.viewPagernew);
        TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
/*
        titles = new ArrayList<String>();
        titles.add("Home");
        titles.add("Settings");
        titles.add("Favorites");*/
       // setViewPagerAdapter();



        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ТЫ нажал", Snackbar.LENGTH_SHORT).show();
            }
        });
    }


   /* public void setViewPagerAdapter()
    {
        ViewPagerAdapter viewPager2Adapter = new ViewPagerAdapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>(); //create an ArrayList of Fragments
        fragmentList.add(new MondayFragment());
        fragmentList.add(new TuesdayFragment());
        fragmentList.add(new WednesdayFragment());

        viewPager2Adapter.setData(fragmentList);
        viewPager.setAdapter(viewPager2Adapter);

    }*/

    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }


    private class TestPagerAdapter extends FragmentPagerAdapter {

        public TestPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MondayFragment();
                case 1:
                    return new TuesdayFragment();
                case 2:
                    return new WednesdayFragment();

            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "First";
                case 1:
                    return "Second";
                case 2:
                    return "Third";
            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}



