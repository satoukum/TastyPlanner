package com.tastyplanner.mealhelpers;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.tastyplanner.R;
import com.tastyplanner.Activities.RecipeActivity;
import com.tastyplanner.Activities.TestFragment;

public class MealAdapter<Recipe> extends ArrayAdapter<com.tastyplanner.objects.Recipe> {

	private ArrayList<com.tastyplanner.objects.Recipe> items;
    private Context context;
    private final TestFragment hacky2;
    //private final MealFragment hacky2;

    
    public MealAdapter(TestFragment hack, Context context, int layoutResourceId, int textViewResourceId, ArrayList<com.tastyplanner.objects.Recipe> items) {
        super(context, layoutResourceId, textViewResourceId, items);
        this.context = context;
        this.items = items;
        this.hacky2 = hack;
    }
        
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.meal_dialog_from_list, null);
        }

        final com.tastyplanner.objects.Recipe recipe_item = items.get(position);
        if (recipe_item != null) {
            
            TextView itemView = (TextView) view.findViewById(R.id.textView1);
            ImageView rscView = (ImageView) view.findViewById(R.id.imageView1);
            if (itemView != null) {
            	itemView.setText("" + recipe_item.toString());
            	
            	itemView.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				Intent childActivityIntent = new Intent(v.getContext(),
        						RecipeActivity.class);
        				childActivityIntent.putExtra("recipe_uuid", recipe_item.getUUID().toString());
        				context.startActivity(childActivityIntent);        			    
        			}
                });
            	
            }
            if (rscView != null) {
            	rscView.setImageResource(recipe_item.getImageResource());
            }
            
            // clear listener
            ImageView clearBtn = (ImageView) view.findViewById(R.id.imageView2);
            clearBtn.setOnClickListener(new OnClickListener() {

    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				
    				DialogFragment newFragment = new MealClearDialogFragment();
    				Bundle b = new Bundle();
    				b.putString("recipe_uuid", recipe_item.getUUID().toString());
    				newFragment.setArguments(b);
    				newFragment.show(hacky2.getFragmentManager(), "remove meal");
    				
    			}
            });
         }
        
        return view;
    }
    
}
