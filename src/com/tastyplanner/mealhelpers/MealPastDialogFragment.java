package com.tastyplanner.mealhelpers;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.tastyplanner.R;
import com.tastyplanner.Activities.RecipeActivity;
import com.tastyplanner.objects.Recipe;

public class MealPastDialogFragment extends DialogFragment {
	
	MealPastDialogFragment mpdf;
	
    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		mpdf = this;
		
		// Inflate the layout to use as dialog or embedded fragment
		View v = inflater.inflate(R.layout.meal_dialog_past, container, false);
				
		ListView pastlv1 = (ListView) v.findViewById(R.id.pastListView1);
		
	        final ArrayList<com.tastyplanner.objects.Recipe> rItems = com.tastyplanner.objects.DataSingleton.getInstance().getUser().getPastRecipesList(); /**
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f35")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f34")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f33")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664 -439a-a6f9-da3e4af81f32")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f31")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f30")));
	        rItems.add(DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39")));
/**
		final Recipe[] rItems = 
	        {
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f35")),
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f34")), 
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f33")),
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32")), 
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f31")),
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f30")),     	  
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39")),
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f")), 
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb")),
	        	DataSingleton.getInstance().getRecipes().get(java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda")),
	        };
*/	        
		
		// TODO fix up
	    ArrayAdapter<com.tastyplanner.objects.Recipe> a = new JunkAdapter<com.tastyplanner.objects.Recipe>(this.getActivity(), R.layout.meal_dialog_from_list2, R.id.textView1, rItems);
		
	    pastlv1.setAdapter(a);
	        
	    pastlv1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View v,
						int arg2, long arg3) {
					Intent childActivityIntent = new Intent(v.getContext(), RecipeActivity.class);
					
					childActivityIntent.putExtra("recipe_uuid", ((Recipe)rItems.get(arg2)).getUUID().toString());
					childActivityIntent.putExtra("allowpin", "true");
					
					v.getContext().startActivity(childActivityIntent);
				}
	        });
	        
		ListView pastlv2 = (ListView) v.findViewById(R.id.pastListView2);
	        
		ArrayAdapter<com.tastyplanner.objects.Recipe> a2 = new JunkAdapter<com.tastyplanner.objects.Recipe>(this.getActivity(), R.layout.meal_dialog_from_list2, R.id.textView1, rItems);
		
	    pastlv2.setAdapter(a2);
	        
	        pastlv2.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View v,
						int arg2, long arg3) {
					Intent childActivityIntent = new Intent(v.getContext(), RecipeActivity.class);
					
					childActivityIntent.putExtra("recipe_uuid", ((Recipe)rItems.get(arg2)).getUUID().toString());
					childActivityIntent.putExtra("allowpin", "true");
					
					v.getContext().startActivity(childActivityIntent);
				}
	        });

	    Button cancelBtn = (Button) v.findViewById(R.id.cancelBtn);  
		cancelBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// Cancel
				mpdf.dismiss();
			}
			
		});
	        
		return v;
	}
	/**
	public List populate() {
		ArrayList<Recipe> rl = new ArrayList<Recipe>();
		
		Recipe r = new Recipe();
		r.setName("Some Recipe Name..."); // !!
		
		rl.add(r);
		
		return rl;
	}
	*/

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
