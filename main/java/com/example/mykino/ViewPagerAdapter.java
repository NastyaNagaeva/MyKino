package com.example.mykino;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public void setData(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       // return fragments.get(position);
        switch (position){
            case 0:
                return new MondayFragment();

            case 1:
                return new TuesdayFragment();
            case 2:
                return new WednesdayFragment();
            default:
                return new MondayFragment();
        }
    }

    @Override
    public int getItemCount() {
       // return 3;
        return fragments.size();
    }
}
