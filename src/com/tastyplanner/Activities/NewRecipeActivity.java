package com.tastyplanner.Activities;


import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class NewRecipeActivity extends Activity {
    int mNum;

    NewRecipeActivity nra;

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        setContentView(R.layout.activity_newrecipe);
        
        //
        nra = this;
        
        TextView mealsBtn = (TextView) findViewById(R.id.mealsBtn);
        mealsBtn.setText("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() + ")");
        mealsBtn.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				// TODO Auto-generated method stub
				System.out.println("MealsBtn Pushed");
				DataSingleton.getInstance().getSTD().setCurrentItem(0);
				nra.finish();
				DataSingleton.getInstance().getLSTD().finish();
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
				nra.finish();
				DataSingleton.getInstance().getLSTD().finish();
				return false;
			}
        	
        });
        	
        }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
        
        
    }
