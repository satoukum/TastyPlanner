package com.tastyplanner.listhelpers;

import java.util.ArrayList;

import com.tastyplanner.R;
import com.tastyplanner.R.id;
import com.tastyplanner.R.layout;
import com.tastyplanner.objects.DataSingleton;
import com.tastyplanner.objects.Ingredient;
import com.tastyplanner.objects.ShoppingCategory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Taken from: http://www.dreamincode.net/forums/topic/270612-how-to-get-started-with-expandablelistview/
 * 
 *
 */
public class ListExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ShoppingCategory> groups;
	public ListExpandableListAdapter(Context context, ArrayList<ShoppingCategory> groups) {
		this.context = context;
		this.groups = groups;
	}

	public void addItem(Ingredient item, ShoppingCategory group) {
		if (!groups.contains(group)) {
			groups.add(group);
		}
		int index = groups.indexOf(group);
		ArrayList<Ingredient> ch = groups.get(index).getIngredientList();
		ch.add(item);
		groups.get(index).setIngredientList(ch);
	}
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		final Ingredient child = (Ingredient) getChild(groupPosition, childPosition);
		child.setCategory(((ShoppingCategory)getGroup(groupPosition)).toString());
		
		if (view == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = infalInflater.inflate(R.layout.list_expandlist_child_item, null);
		}
		final TextView tv = (TextView) view.findViewById(R.id.tvChild);
		tv.setText(child.toString());
		
		tv.setTag(child.getTag());
		
		// TODO Pantry Feature
		//if (childPosition != 1) {
		//	tv.setCompoundDrawablesWithIntrinsicBounds((res.getDrawable(R.drawable.icon_pantry2_blank), null, null, null);
		//}
		//if (childPosition != 1) {
		//	tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		//}
				
		// Allows user to "strike" off items after they've been found
		if (child.Striked) {
			//tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
			tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_checkbox_checked3, 0, 0, 0);
		} else {
			//tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
			tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_checkbox3, 0, 0, 0);
		}
		
		// TODO Strikethrough feature
		tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	if (!child.Striked) { // strike text
            		//System.out.println("Strike Text");
            		//tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_checkbox_checked3, 0, 0, 0);
            		
            		child.setStriked(true);
            		
            		// move child to the bottom...
            		int num = -1;
            		ArrayList<ShoppingCategory> scList = DataSingleton.getInstance().getUser().getShoppingList();
            		for (ShoppingCategory sc : scList) {
            			if( sc.getName().equals(child.getCategory())) {
            				ArrayList<Ingredient> iList = sc.getIngredientList();
            				num = sc.getNumber() + 10; //TODO bad habbit
            				iList.remove(child);
            			}
            		}
            		for (ShoppingCategory sc : scList) {
            			if (sc.getNumber() == num) {
            				sc.addIngredient(child);
            			}
            		}
            		            		
            		// update list/cart divider
            		DataSingleton.getInstance().getUser().incrementTotalCartItems();
            		DataSingleton.getInstance().getUser().decrementTotalListItems();
            		
            		//DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
            		tv.postDelayed(hide, 400);
            		
            	} else { // unstrike text
            		//System.out.println("Un-Strike Text");
            		//tv.setPaintFlags( tv.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            		tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_checkbox3, 0, 0, 0);
            		child.setStriked(false);
            		
            		// move child to the top...
            		int num = -1;
            		ArrayList<ShoppingCategory> scList = DataSingleton.getInstance().getUser().getShoppingList();
            		for (ShoppingCategory sc : scList) {
            			if( sc.getName().equals(child.getCategory())) {
            				ArrayList<Ingredient> iList = sc.getIngredientList();
            				num = sc.getNumber() - 10; //TODO bad habbit
            				iList.remove(child);
            			}
            		}
            		for (ShoppingCategory sc : scList) {
            			if (sc.getNumber() == num) {
            				sc.addIngredient(child);
            			}
            		}
            		
            		DataSingleton.getInstance().getUser().decrementTotalCartItems();
            		DataSingleton.getInstance().getUser().incrementTotalListItems();
            		
            		//DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
            		tv.postDelayed(hide, 400);
            	}
            }
        });
    		
		return view;
	}
	
	Runnable hide = new Runnable() {
	    @Override
	    public void run() {
	    	DataSingleton.getInstance().getListAdapter().notifyDataSetChanged();
	    }
	};

	public int getChildrenCount(int groupPosition) {
		ArrayList<Ingredient> chList = groups.get(groupPosition).getIngredientList();
		return chList.size();

	}

	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	public int getGroupCount() {
		return groups.size();
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isLastChild, View view,
			ViewGroup parent) {
		ShoppingCategory group = (ShoppingCategory) getGroup(groupPosition);
		if (view == null) {
			LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = inf.inflate(R.layout.list_expandlist_group_item, null);
		}
		TextView tv = (TextView) view.findViewById(R.id.tvGroup);
		RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.cartRL);
		
		int numList = DataSingleton.getInstance().getUser().getTotalListItems();
		int numCart = DataSingleton.getInstance().getUser().getTotalCartItems();
		
		if (numList == 0 && numCart == 0) {
			tv.setVisibility(View.GONE);
			rl.setVisibility(View.GONE);
		} else if (group.getName().equals("PRETEND")) {
			tv.setVisibility(View.GONE);
			
			DataSingleton.getInstance().setCartRL1(rl);
			DataSingleton.getInstance().setRL2Gone();
			DataSingleton.getInstance().setRL1Visible();
			
		} else if (group.getIngredientList().size() != 0) {
			tv.setVisibility(View.VISIBLE);
			tv.setText(group.getName());
			rl.setVisibility(View.GONE);
			
			if (DataSingleton.getInstance().getCartRL1() != null && DataSingleton.getInstance().getCartRL1().isShown()) {
				DataSingleton.getInstance().setRL2Gone();
			} else {
				if (group.getNumber() > 10) {
					DataSingleton.getInstance().setRL2Gone(); // bottom of the list
				} else {
					DataSingleton.getInstance().setRL2Visible();
				}
			}
			
		} else { // Last group item
			//DataSingleton.getInstance().setRL2Gone();
			if (DataSingleton.getInstance().getCartRL1() != null && DataSingleton.getInstance().getCartRL1().isShown()) {
				DataSingleton.getInstance().setRL2Gone();
			} else {
				if (group.getNumber() > 10) {
					DataSingleton.getInstance().setRL2Gone(); // bottom of the list
				} else {
					DataSingleton.getInstance().setRL2Visible();
				}
			}
			
			tv.setVisibility(View.GONE);
			rl.setVisibility(View.GONE);
		}
/**		
		// tricky code used to display the list/cart
		if (group.getIngredientList().size() != 0) {
			tv.setVisibility(View.VISIBLE);
			rl.setVisibility(View.GONE);

			//DataSingleton.getInstance().setRL2Stuff(); //
			//DataSingleton.getInstance().getCartRL1().setVisibility(View.GONE); //
			
			tv.setText(group.getName());
		} else if (group.getName().equals("PRETEND")) {
			System.out.println("visible");
			//DataSingleton.getInstance().getCartRL2().setVisibility(View.GONE); //
			
			if (numList == 0 && numCart == 0) {
				tv.setVisibility(View.GONE);
				rl.setVisibility(View.GONE);
			} else {
			
				tv.setVisibility(View.GONE);
				//DataSingleton.getInstance().setRL1Stuff(); // 
			}
		} else {
			//DataSingleton.getInstance().getCartRL2().setVisibility(View.GONE); //
			tv.setVisibility(View.GONE);
			rl.setVisibility(View.GONE);
		}
*/		
		return view;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}


