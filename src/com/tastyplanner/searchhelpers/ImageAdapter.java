package com.tastyplanner.searchhelpers;

import java.util.ArrayList;
import java.util.Collection;

import com.tastyplanner.objects.DataSingleton;
import com.tastyplanner.objects.Recipe;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public ImageAdapter(Context c, ArrayList<Recipe> mThumbIds) {
		mContext = c;
		this.mThumbIds = mThumbIds;
	}

	public int getCount() {
        return mThumbIds.size();
		//return mThumbIds.length;
    }

    public Recipe getItem(int position) {
        return mThumbIds.get(position);
    }

    public long getItemId(int position) {
        return mThumbIds.get(position).getImageResource();
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(270, 270)); // 270 px by 270 px image
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds.get(position).getImageResource());
        return imageView;
    }

    // references to our images
    private ArrayList<Recipe> mThumbIds; // = (Recipe[]) DataSingleton.getInstance().getRecipes().values().toArray();
    
/**    
    private Recipe[] mThumbIds = {
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
 */   	    
/**    	    		
    		new Recipe("Chicken Pot Pie Bits", R.drawable.recipe2, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")),
    		new Recipe("Lentil Soup", R.drawable.recipe6, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")),
    		new Recipe("Broccoli Chicken Divan", R.drawable.recipe_broccolichickendivan, java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39")),
    		new Recipe("Sweet and Sour Meatballs", R.drawable.recipe_sweetandsourmeatballs, java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f")),
    		new Recipe("Easy Chicken Pot Pie", R.drawable.recipe_easychickenpotpie, java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb")),
    		new Recipe("Sweet and Sour Chicken", R.drawable.recipe_sweetandsourchicken, java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda")),
    		new Recipe("Creamy Braised Chicken with Pappardelle", R.drawable.recipe3, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")), 
    		new Recipe("Cowboy Cookies", R.drawable.recipe4, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")),
    		new Recipe("Triple Decker Peaut Butter Brownies", R.drawable.recipe5, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")), 
    		new Recipe("Cappuccino-Chocolate Cupcakes", R.drawable.recipe1, java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f39")),
*/    		
/**    		
    		R.drawable.recipe2, R.drawable.recipe6,
            R.drawable.recipe_broccolichickendivan, R.drawable.recipe_sweetandsourmeatballs,
            R.drawable.recipe_easychickenpotpie, R.drawable.recipe_sweetandsourchicken,
            R.drawable.recipe3, R.drawable.recipe4,
            R.drawable.recipe5, R.drawable.recipe1
*/            
//    };
	
}
