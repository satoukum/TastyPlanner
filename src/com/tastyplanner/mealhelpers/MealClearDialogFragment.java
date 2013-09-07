package com.tastyplanner.mealhelpers;

import java.util.ArrayList;

import com.tastyplanner.objects.Recipe;
import com.tastyplanner.objects.Ingredient;
import com.tastyplanner.objects.ShoppingCategory;
import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MealClearDialogFragment extends DialogFragment {
	
	MealClearDialogFragment mcdf;
	
    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		// Inflate the layout to use as dialog or embedded fragment
		
		mcdf = this;
		
		final String UUID = (String) this.getArguments().get("recipe_uuid");
		
		View v = inflater.inflate(R.layout.meal_dialog_clear, container, false);
		
		Button clearMealBtn = (Button) v.findViewById(R.id.clearMealBtn);
		clearMealBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				DataSingleton.getInstance().getUser().removeFromMeals(java.util.UUID.fromString(UUID));
				DataSingleton.getInstance().getMealAdapter().notifyDataSetChanged();
				DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
				
				int size = DataSingleton.getInstance().getUser().getMealRecipesList().size();
				DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + size + ")");
				
				if (size == 0) {
					DataSingleton.getInstance().getTutorial().setVisibility(View.VISIBLE);
				}
				
				mcdf.dismiss();
			}
			
		});
		
		Button clearAllMealsBtn = (Button) v.findViewById(R.id.clearAllMealsBtn);
		clearAllMealsBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				ArrayList<ShoppingCategory> sl = DataSingleton.getInstance().getUser().getShoppingList();
				for (ShoppingCategory sc : sl) {
					ArrayList<Ingredient> il = sc.getIngredientList();
					if (sc.getNumber() > 10) {
						for (Ingredient i : il) {
							i.setCategory(i.getCategory().trim());
						}
					}
					il.clear();
				}
				DataSingleton.getInstance().getUser().setTotalCartItems(0);
				DataSingleton.getInstance().getUser().setTotalListItems(0);
				
				DataSingleton.getInstance().setRL2Gone(); //
				
				DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
				
				ArrayList<Recipe> rl = DataSingleton.getInstance().getUser().getMealRecipesList();
				for (Recipe r : rl) {
					r.setPlanned(false);
				}
				rl.clear();

				DataSingleton.getInstance().getMealAdapter().notifyDataSetChanged();
				
				// size will always be 0 in this case.
				DataSingleton.getInstance().getSTD().setTabName(0,"MEALS (" + 0 + ")");
				DataSingleton.getInstance().getTutorial().setVisibility(View.VISIBLE);
				
				mcdf.dismiss();
			}
			
		});
		
		Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);
		cancelBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Cancel
				mcdf.dismiss();
			}
			
		});
		
		return v;
	}

	/** The system calls this only when creating the layout in a dialog. */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// The only reason you might override this method when using onCreateView() is
		// to modify any dialog characteristics. For example, the dialog includes a
		// title by default, but your custom layout might not need it. So here you can
		// remove the dialog title, but you must call the superclass to get the Dialog.
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		return dialog;
	}
}
