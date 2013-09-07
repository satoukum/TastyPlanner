package com.tastyplanner.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {
    private static final String[] CONTENT = new String[] { "Meals", "List" };

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
       
        DataSingleton.getInstance().setSTD(indicator);
        
        //TODO fix hack - Set the name of the tab
        int size = DataSingleton.getInstance().getUser().getMealRecipesList().size();
        DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + size + ")");
        
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	if (CONTENT[position % CONTENT.length].toUpperCase().startsWith("MEALS")) {
        		return CONTENT[position % CONTENT.length].toUpperCase() + " (5)";
        	}
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
          return CONTENT.length;
        }
    }
}
