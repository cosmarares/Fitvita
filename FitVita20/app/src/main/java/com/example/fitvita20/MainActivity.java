package com.example.fitvita20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MuscleFragment muscleFragment;
    private HomeFragment homeFragment;
    private SettingsFragment settingsFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        muscleFragment = new MuscleFragment();
        homeFragment = new HomeFragment();
        settingsFragment = new SettingsFragment();
        profileFragment = new ProfileFragment();
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter v = new ViewPagerAdapter(getSupportFragmentManager(),0);
        v.addFragment(homeFragment);
        v.addFragment(muscleFragment);
        v.addFragment(profileFragment);
        v.addFragment(settingsFragment);

        viewPager.setAdapter(v);

        //tabLayout.getTabAt(0).setText("Home");
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);


        //tabLayout.getTabAt(1).setText("Muscle");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_fitness_center_24);

        //tabLayout.getTabAt(2).setText("Profile");
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_fastfood_24);

        //tabLayout.getTabAt(3).setText("Settings");
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_settings_24);

        tabLayout.getTabAt(0).select();

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentsTitles = new ArrayList<>();

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),
                R.drawable.back, null);

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment (Fragment fragment){
            fragments.add(fragment);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
