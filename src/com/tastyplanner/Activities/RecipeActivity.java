package com.tastyplanner.Activities;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//import com.tastyplanner.Up.ActionBarCompat;
import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;
import com.tastyplanner.objects.Ingredient;
import com.tastyplanner.objects.Recipe;
//import com.tastyplanner.tabs.MealsSectionFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class RecipeActivity extends Activity {
    int mNum;
	Recipe r = new Recipe();
	
	RecipeActivity ra;
	TextView mealTab;
	TextView planMeal;

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //ActionBarCompat.setDisplayHomeAsUpEnabled(this, true); // Back button up top?
        
        // Default Recipe?
        String UUID = this.getIntent().getStringExtra("recipe_uuid");        
    	r = DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString(UUID));
        
        setContentView(R.layout.activity_recipe_pin);
        setBottomBarListeners();	

        defaultRecipie();
        
        mealTab = (TextView) findViewById(R.id.mealsBtn);
        
        // 
        planMeal = (TextView) findViewById(R.id.planmeal);
        planMeal.setVisibility(View.GONE);
        
        // Sets the Meal and List Tabs at the top of the page
        setTabs();
        
    }
    
    public void setTabs() {
    	//TODO less tacky? - why do I have to use onTouchListeners?
        ra = this;
        
        TextView mealsBtn = (TextView) findViewById(R.id.mealsBtn);
        mealsBtn.setText("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() + ")");
        mealsBtn.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				DataSingleton.getInstance().getSTD().setCurrentItem(0);
				ra.finish();
				
				if (DataSingleton.getInstance().getLSTD() != null) {
					DataSingleton.getInstance().getLSTD().finish();
				}
				return false;
			}
        	
        });
        TextView listBtn = (TextView) findViewById(R.id.listBtn);
        listBtn.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent arg1) {
				DataSingleton.getInstance().getSTD().setCurrentItem(1);
				ra.finish();
				if (DataSingleton.getInstance().getLSTD() != null) {
					DataSingleton.getInstance().getLSTD().finish();
				}
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
    
    /**
     * Initializes the bottom bar buttons with listeners
     * 		like, save, plan, share
     */
    public void setBottomBarListeners() {
    	
    	// like 
    	final Button likeBtn = (Button) this.findViewById(R.id.likeBtn);
    	
    	if (!r.getHarted()) {
    		likeBtn.setTag("unchecked");
    		likeBtn.setText("Like");
    	} else {
    		likeBtn.setTag("checked");
    		likeBtn.setText("Unlike");
    	}
    		
    	likeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (likeBtn.getTag().equals("unchecked")) {					
					
					likeBtn.setText("Unlike");
					likeBtn.setTag("checked");
					r.setHarted(true);
					DataSingleton.getInstance().getUser().addToHarted(r.getUUID());
					
				} else {
					//likeImgView.setBackgroundResource(R.drawable.icon_heart);
					likeBtn.setTag("unchecked");
					likeBtn.setText("Like");
					r.setHarted(false);
					DataSingleton.getInstance().getUser().removeFromHarted(r.getUUID());
					
				}
			}
        	
        });
    	
    	// save
    	final Button saveBtn = (Button) this.findViewById(R.id.saveBtn);
    	
    	if (r.getPinned()) {
    		saveBtn.setTag("unchecked");
    		saveBtn.setText("Unsave");
    	} else {
    		saveBtn.setTag("checked");
    		saveBtn.setText("Save");
    	}
    		
    	saveBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (saveBtn.getTag().equals("unchecked")) {
					
					saveBtn.setText("Unsave");
					saveBtn.setTag("checked");
					r.setPinned(true);
					DataSingleton.getInstance().getUser().addToPinned(r.getUUID());
					
					synchronized (DataSingleton.getInstance().getSavedIA()) {
						DataSingleton.getInstance().getSavedIA().notify();
					}
					
				} else {

					saveBtn.setTag("unchecked");
					saveBtn.setText("Save");
					r.setPinned(false);
					DataSingleton.getInstance().getUser().removeFromPinned(r.getUUID());
					
					synchronized (DataSingleton.getInstance().getSavedIA()) {
						DataSingleton.getInstance().getSavedIA().notify();
					}
					
				}
			}
        	
        });
    	
    	// plan meal
    	final Button planBtn = (Button) this.findViewById(R.id.planBtn);
    	
    	if (!r.getPlanned()) {
    		planBtn.setTag("unchecked");
    		planBtn.setText("Plan Meal");
    	} else {
    		planBtn.setTag("checked");
    		planBtn.setText("Unplan Meal");
    	}
    	
    	planBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (planBtn.getTag().equals("unchecked")) {
					
					int ingreSize = r.getIngredientList().size();
					//Toast.makeText(ra.getBaseContext(), "Adding " + ingreSize + " ingredients to List", Toast.LENGTH_SHORT).show();
					// Adding 1 Meal to Meal Plan \n(12 Ingredients)
					planMeal.setText(" Adding 1 Meal to Meal Plan" + " (" + ingreSize + " Ingredients)");
					planMeal.setVisibility(View.VISIBLE);   
			        planMeal.postDelayed(hide, 1500);

					
					planBtn.setText("Unplan Meal");
					planBtn.setTag("checked");
					r.setPlanned(true);
					
					DataSingleton.getInstance().getUser().addToMeals(r.getUUID());
					mealTab.setText("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() + ")");
					
					DataSingleton.getInstance().getMealAdapter().notifyDataSetChanged();
					DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
					
					int size = DataSingleton.getInstance().getUser().getMealRecipesList().size();
					DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + size + ")");
					
					if (size == 0) {
						DataSingleton.getInstance().getTutorial().setVisibility(View.VISIBLE);
					} else {
						DataSingleton.getInstance().getTutorial().setVisibility(View.GONE);
					}
					
					if (DataSingleton.getInstance().getLSTD() != null) {
						DataSingleton.getInstance().getLSTD().setBtnName("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() +  ")");
					}
										
				} else {
					
					int ingreSize = r.getIngredientList().size();
					//Toast.makeText(ra.getBaseContext(), "Removing " + ingreSize + " ingredients from List", Toast.LENGTH_SHORT).show();
					// Removing 1 Meal to Meal Plan \n(12 Ingredients)
					planMeal.setText(" Removing 1 Meal from Meal Plan" + " (" + ingreSize + " Ingredients)");
					planMeal.setVisibility(View.VISIBLE);   
			        planMeal.postDelayed(hide, 1500);
					
					planBtn.setText("Plan Meal");
					planBtn.setTag("unchecked");
					r.setPlanned(false);
					
					DataSingleton.getInstance().getUser().removeFromMeals(r.getUUID());
					mealTab.setText("MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() + ")");
					
					DataSingleton.getInstance().getMealAdapter().notifyDataSetChanged();
					DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();

					DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + DataSingleton.getInstance().getUser().getMealRecipesList().size() + ")");
					
					int size = DataSingleton.getInstance().getUser().getMealRecipesList().size();
					if (DataSingleton.getInstance().getLSTD() != null) {
						DataSingleton.getInstance().getLSTD().setBtnName("MEALS (" + size +  ")");
					}
					
					if (size == 0) {
						DataSingleton.getInstance().getTutorial().setVisibility(View.VISIBLE);
					} else {
						DataSingleton.getInstance().getTutorial().setVisibility(View.GONE);
					}

				}
			}
    		
    	});
    	
    }
    
    Runnable hide = new Runnable() {
        @Override
        public void run() {
            planMeal.setVisibility(View.GONE);
        }
    };

    ImageView recipeimg;
    TextView recipiename;
	TextView ingredients;
	TextView directions;
	TextView nutrition;
	TextView servings;
	TextView reviews;
	
    public void defaultRecipie() {
    	
    	//recipiename = (TextView) findViewById(R.id.textView1);
    	recipeimg = (ImageView) findViewById(R.id.recipeImg);
        servings = (TextView) findViewById(R.id.textView7);
        ingredients = (TextView) findViewById(R.id.textView8);        
        directions = (TextView) findViewById(R.id.textView9);
        nutrition = (TextView) findViewById(R.id.textView10);
        reviews = (TextView) findViewById(R.id.textView11);
        
    	recipeimg.setImageResource(r.getImageResource());
            	
    	servings.setText("\n" +
        		"Ready in 1 Hour and 10 minutes, Servings: 8 \n");
    	
    	String ingredientsString = "\n";
    	for (Ingredient ingre : r.getIngredientList()) {
    		ingredientsString += ingre.toString() + "\n";
    	}
    	ingredients.setText(ingredientsString);
        
/**        
        ingredients.setText("\n" +
        		"1 lb. Ground Beef \n" +
        		"1 Egg \n" +
        		"1/2 c. Chopped Onion \n" +
        		"1/4 c. Bread Crumbs \n" +
        		"1 t. Salt \n" +
        		"1 t. Pepper \n" +
        		"1 c. Rice \n" +
        		"1 c. Pineapple Juice \n" +
        		"1 T. Oil \n" +
        		"1 T. Soy Sauce \n" +
        		"1/2 c. Sugar \n" +
        		"3 T. Vinegar \n" +
        		"15 oz. can Pineapple Chunks \n" +
        		"8 oz. Mandarin Oranges \n");
*/        
        directions.setText("\n" +
        		"1. Combine rice with 1 1/2 c. water and cook for 20 minutes. \n\n" +
        		"2. While rice is cooking, combine ground beef, egg, onion, bread crumbs, " +
        			"and salt and pepper. Form into 1-in meatballs, and broil on a rimmed " +
        			"cookie sheet on low in the oven until cooked through. \n\n" +
        		"3. Bring pineapple juice and oil to a boil for one minute. Meanwhile, mix" +
        			"soy sauce, sugar, and vinegar together. Add to the boiling juice and " +
        			"simmer on medium until sauce thickens. \n\n" +
    			"4. Combine sauce, meatballs, and canned fruit. Serve hot over fresh rice." +
    				"Can be served or warmed in crockpot as well. \n");
        
        nutrition.setText("" +
        		"\n" +
        		"Calories, 2080" +
        		"\n");
        
        reviews.setText("" +
        		"\n" +
        		"Reviews, 34" +
        		"\n");    	
    }
	
}
