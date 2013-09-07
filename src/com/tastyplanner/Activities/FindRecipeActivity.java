package com.tastyplanner.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;
import com.viewpagerindicator.TabPageIndicator;

public class FindRecipeActivity extends FragmentActivity {
    private static final String[] CONTENT = new String[] { "Search", "Liked", "Saved", "Past", "Social" };

    FindRecipeActivity lstd;
    TextView mealsBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_find_recipe);

        lstd = this;
        DataSingleton.getInstance().setLSTD(this);
        
        //TODO less tacky? - why do I have to use onTouchListeners?
        mealsBtn = (TextView) findViewById(R.id.mealsBtn);
        setBtnName("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() +  ")");
        mealsBtn.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				System.out.println("MealsBtn Pushed");
				DataSingleton.getInstance().getSTD().setCurrentItem(0);
				lstd.finish();
				return false;
			}
        	
        });
        TextView listBtn = (TextView) findViewById(R.id.listBtn);
        listBtn.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				System.out.println("ListBtn Pushed");
				DataSingleton.getInstance().getSTD().setCurrentItem(1);
				lstd.finish();
				return false;
			}
        	
        });
        
        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
       
    }
    
    public void setBtnName(String name) {
    	mealsBtn.setText(name);
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
        		return CONTENT[position % CONTENT.length].toUpperCase() + " (4)";
        	}
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
          return CONTENT.length;
        }
    }
}
