package com.example.stressmanagementapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {

    private final String[] titles= new String[]{"Patients","CareGivers"};

    public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new PatientFragment();
            case 1: return new CareGiverFragment();
        }
        return new PatientFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
