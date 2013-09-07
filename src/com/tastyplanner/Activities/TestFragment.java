package com.tastyplanner.Activities;

import java.util.ArrayList;
import java.util.Locale;

import com.tastyplanner.R;
import com.tastyplanner.listhelpers.ListAddDialogFragment;
import com.tastyplanner.listhelpers.ListClearDialogFragment;
import com.tastyplanner.listhelpers.ListExpandableListAdapter;
import com.tastyplanner.mealhelpers.MealAdapter;
import com.tastyplanner.objects.DataSingleton;
import com.tastyplanner.objects.Recipe;
import com.tastyplanner.searchhelpers.ImageAdapter;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class TestFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";

    public static TestFragment newInstance(String content) {
        TestFragment fragment = new TestFragment();

        if (content.toUpperCase(Locale.US).startsWith("MEALS")) {
        	fragment.mContent = "meals";
        } else if (content.toUpperCase(Locale.US).equals("LIST")) {
        	fragment.mContent = "list";
        } else if (content.toUpperCase(Locale.US).equals("SOCIAL")) {
        	fragment.mContent = "social";
        } else if (content.toUpperCase(Locale.US).equals("LIKED")) {
        	fragment.mContent = "liked";
        } else if (content.toUpperCase(Locale.US).equals("SAVED")) {
        	fragment.mContent = "saved";
        } else if (content.toUpperCase(Locale.US).equals("PAST")) {
        	fragment.mContent = "past";
        }

        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }
    
    static View rootView;
    private static ArrayList<com.tastyplanner.objects.ShoppingCategory> ExpListItems = new ArrayList<com.tastyplanner.objects.ShoppingCategory>();
	private ExpandableListView ExpandList;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	//System.out.println("mContent" + mContent);
    	if (mContent.toUpperCase(Locale.US).startsWith("MEALS")) {
    		buildMeals(inflater, container, savedInstanceState);
    	} else if (mContent.toUpperCase(Locale.US).equals("LIST")) {
        	buildList(inflater, container, savedInstanceState);
    	} else if (mContent.toUpperCase(Locale.US).equals("SOCIAL")) {
    		buildSocial(inflater, container, savedInstanceState);
        } else if (mContent.toUpperCase(Locale.US).equals("LIKED")) {
        	ImageAdapter imgAdapter = new ImageAdapter(rootView.getContext(), DataSingleton.getInstance().getUser().getFavoriteRecipesList());
    		DataSingleton.getInstance().setLikedIA(imgAdapter);
        	buildSearchTab(inflater, container, savedInstanceState, imgAdapter);
        } else if (mContent.toUpperCase(Locale.US).equals("SAVED")) {
        	ImageAdapter imgAdapter = new ImageAdapter(rootView.getContext(), DataSingleton.getInstance().getUser().getPinnedRecipesList());        	
        	DataSingleton.getInstance().setSavedIA(imgAdapter);
        	buildSearchTab(inflater, container, savedInstanceState, imgAdapter);
        } else {
        	ImageAdapter imgAdapter = new ImageAdapter(rootView.getContext(), DataSingleton.getInstance().getAllRecipes());
        	DataSingleton.getInstance().setAllRecipesIA(imgAdapter);
        	buildSearchTab(inflater, container, savedInstanceState, imgAdapter);
        }
    	    	
        return rootView;
    }
    
    private void buildMeals(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	rootView = inflater.inflate(R.layout.fragment_meals, container, false);
		
		ListView meallv = (ListView) rootView.findViewById(R.id.mealsListView);
		ArrayList<Recipe> list = DataSingleton.getInstance().getUser().getMealRecipesList();
		MealAdapter<Recipe> a = new MealAdapter<Recipe>(this, rootView.getContext(), R.layout.meal_dialog_from_list, R.id.textView1, list);    		
		
		DataSingleton.getInstance().setMealAdapter(a);
        meallv.setAdapter(DataSingleton.getInstance().getMealAdapter());
        
        int size = DataSingleton.getInstance().getUser().getMealRecipesList().size();
        DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + size + ")");
        
        // Tutorial screen
        FrameLayout tutorial = (FrameLayout) rootView.findViewById(R.id.tutorial);
        DataSingleton.getInstance().setTutorial(tutorial);
        
        if (size == 0) {
        	DataSingleton.getInstance().getTutorial().setVisibility(View.VISIBLE);
        } else {
        	DataSingleton.getInstance().getTutorial().setVisibility(View.GONE);
        }
                    
        setBottomMealBtns(rootView);
            	    	
    }
    private void buildList(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	rootView = inflater.inflate(R.layout.fragment_list, container, false);
    	
		ExpandList = (ExpandableListView) rootView.findViewById(R.id.ExpList);
		ExpListItems = DataSingleton.getInstance().getUser().getShoppingList(); //SetIngredients(); //SetStandardGroups();
		DataSingleton.getInstance().setListAdapter(new ListExpandableListAdapter(this.getActivity(), ExpListItems)); //??
		ExpandList.setAdapter(DataSingleton.getInstance().getListAdapter()); // TODO!!
		
		//TODO make less tacky
		int count = DataSingleton.getInstance().getListAdapter().getGroupCount();
		for (int position = 1; position <= count; position++) {
			ExpandList.expandGroup(position - 1);
		}
		ExpandList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			  @Override
			  public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
			      // Doing nothing
			    return true;
			  }
		});
    	
		// 
		RelativeLayout rl = (RelativeLayout) rootView.findViewById(R.id.cartRL2);
		DataSingleton.getInstance().setCartRL2(rl);
		if (DataSingleton.getInstance().getUser().getTotalListItems() == 0 && DataSingleton.getInstance().getUser().getTotalCartItems() == 0) {
			DataSingleton.getInstance().setRL2Gone();
		}
		
    	setBottomListBtns(rootView);
  
    }
    private void buildSocial(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	rootView = inflater.inflate(R.layout.fragment_social, container, false);
    	final GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(rootView.getContext(), DataSingleton.getInstance().getUser().getFavoriteRecipesList()));
    }
    private void buildSearchTab(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, ImageAdapter imgAdapter) {
    	rootView = inflater.inflate(R.layout.fragment_search, container, false);
		rootView.findViewById(R.id.mainLayout).requestFocus();
		
		final GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
	    gridview.setAdapter(imgAdapter);

	    gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				
				Intent childActivityIntent = new Intent(v.getContext(),
						RecipeActivity.class);
						
				childActivityIntent.putExtra("recipe_uuid", (String) ((com.tastyplanner.objects.Recipe)gridview.getAdapter().getItem(position)).getUUID().toString());
				childActivityIntent.putExtra("allowpin", "true");
				
				v.getContext().startActivity(childActivityIntent);
		        
			}});
    }
    
    private void setBottomListBtns(final View rootView) {
    	// clear listener
    	
    			Button clearBtn = (Button) rootView.findViewById(com.tastyplanner.R.id.clearBtn);
    			clearBtn.setOnClickListener(new OnClickListener() {

    				@Override
    				public void onClick(View v) {
    					DialogFragment newFragment = new ListClearDialogFragment();
    				    newFragment.show(getFragmentManager(), "clear");
    				}
    				
    			});	
    			
    			// add listener
    			Button addBtn = (Button) rootView.findViewById(R.id.addBtn);
    			addBtn.setOnClickListener(new OnClickListener() {

    				@Override
    				public void onClick(View v) {
    					// TODO Auto-generated method stub
    					// TODO find better way to change the text
    					DialogFragment newFragment = new ListAddDialogFragment();
    				    newFragment.show(getFragmentManager(), "add");
    				}
    				
    			});	
    				    	
    }
    
    private void setBottomMealBtns(final View rootView) {
    	final Button FindRecipeBtn = (Button) rootView.findViewById(R.id.addBtn);
    	//FindRecipeBtn.getBackground().setAlpha(85);
    	FindRecipeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent childActivityIntent = new Intent(v.getContext(),
						FindRecipeActivity.class);
				rootView.getContext().startActivity(childActivityIntent);    
				
			}
        	
        });
    	
    	final Button NewRecipeBtn = (Button) rootView.findViewById(R.id.addBtn2);
    	NewRecipeBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent childActivityIntent = new Intent(v.getContext(),
						NewRecipeActivity.class);
				rootView.getContext().startActivity(childActivityIntent);    
				
			}
        	
        });
    	
    	final Button pastBtn = (Button) rootView.findViewById(R.id.pastBtn);
    	pastBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				DialogFragment newFragment = new com.tastyplanner.mealhelpers.MealPastDialogFragment();
			    newFragment.show(getFragmentManager(), "Past Meals");  
				
			}
        	
        });
    }
    


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}
