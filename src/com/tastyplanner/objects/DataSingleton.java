package com.tastyplanner.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.tastyplanner.R;
import com.viewpagerindicator.TabPageIndicator;
import com.tastyplanner.Activities.FindRecipeActivity;
import com.tastyplanner.Activities.MainActivity;
import com.tastyplanner.listhelpers.ListExpandableListAdapter;
import com.tastyplanner.mealhelpers.MealAdapter;
import com.tastyplanner.searchhelpers.ImageAdapter;
//import com.tastyplanner.MealExpandableListAdapter;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DataSingleton {

	private static DataSingleton instance = null; 
	
	public static User user = new User();
	public static HashMap<java.util.UUID, com.tastyplanner.objects.Recipe> recipes = new HashMap<java.util.UUID, com.tastyplanner.objects.Recipe>();
	
	protected DataSingleton() { 
		// Exists only to defeat instantiation. 
	}
	
	public static DataSingleton getInstance() { 
		if(instance == null) { 
			instance = new DataSingleton(); 
			user = setUser(); // TODO fix up
		} 
		return instance; 
	}
	
	public ArrayList<Recipe> getAllRecipes() {
		ArrayList<Recipe> recipesArray = new ArrayList<Recipe>();
		Set<UUID> keys = recipes.keySet();
		Iterator i = keys.iterator();
		while (i.hasNext()) {
			recipesArray.add(recipes.get(i.next()));
		}
		return recipesArray;
		//recipesArray.addAll()
	}
	
	/**
	 * Holds all the recipes
	 */
	public static void setRecipes() {
		
		recipes = new HashMap<java.util.UUID, com.tastyplanner.objects.Recipe>();
		
		Recipe r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39"));
		r.setImageResource(R.drawable.recipe_broccolichickendivan);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients1());
		r.setName("Broccoli Chicken Divan");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f"));
		r.setImageResource(R.drawable.recipe_sweetandsourmeatballs);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients2());
		r.setName("Sweet and Sour Meatballs");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb"));
		r.setImageResource(R.drawable.recipe_easychickenpotpie);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Easy Chicken Pot Pie");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda"));
		r.setImageResource(R.drawable.recipe_sweetandsourchicken);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients6());
		r.setName("Sweet and Sour Chicken");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		// HASHED
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f35"));
		r.setImageResource(R.drawable.recipe_chickenpotpiebites);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients4());
		r.setName("Chicken Pot Pie Bites");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f34"));
		r.setImageResource(R.drawable.recipe_slowcookerlentilsoupwithturkeybratwurst);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients5());
		r.setName("Lentil Soup");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f33"));
		r.setImageResource(R.drawable.recipe_creamybraisedchickenwithpappardelle);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Creamy Braised Chicken with Pappardelle");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32"));
		r.setImageResource(R.drawable.recipe_cowboycookies);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients3());
		r.setName("Cowboy Cookies");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);

		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f31"));
		r.setImageResource(R.drawable.recipe_tripledeckerpeanutbutterbrownies);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients7());
		r.setName("Triple Decker Peaut Butter Brownies");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);
		
		recipes.put(r.getUUID(), r);
		
		r = new Recipe();
		r.setUUID(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f30"));
		r.setImageResource(R.drawable.recipe_cappuccinochocolatecupcakes);
		r.setDirectionsList(setFakeDirections1());
		r.setIngredientList(setFakeIngredients8());
		r.setName("Cappuccino-Chocolate Cupcakes");
		r.setReadyInHours(1);
		r.setReadyInMinutes(30);
		r.setServings(4);

		recipes.put(r.getUUID(), r);
		
		
	}

	public HashMap<java.util.UUID, com.tastyplanner.objects.Recipe> getRecipes(){
		return recipes;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	
	public static User setUser() {
		
		// Recipes database
		setRecipes(); // TODO
		
	    // SET UP SINGLETON
	    User testUser = new User();
	    testUser.setEmail("nielsen.marissa@gmail.com");
	    testUser.setName("Marissa Nielsen");
	    testUser.setUsername("marissa");
	    
	    testUser.setFbloginid(null); // TODO
	    testUser.setFollowerList(null); //TODO
	    testUser.setFollowingList(null); //TODO

	    testUser.setPinnedRecipesList(null); //TODO
	    testUser.setFavoriteRecipesList(null); //TODO
	    testUser.setShoppingList();
	    testUser.setDefaultMeals();
	    testUser.setDefaultLikedMeals();
	    testUser.setDefaultPinnedMeals();
	    testUser.setPastRecipes();
	    
	    return testUser;
	}


    
private static ArrayList<String> fakeDirections = new ArrayList<String>();
private static ArrayList<String> setFakeDirections1() {
	
	fakeDirections.add("Combine rice with 1 1/2 c. water and cook for 20 minutes.");
	fakeDirections.add("While rice is cooking, combine ground beef, egg, onion, bread crumbs, " +
    			"and salt and pepper. Form into 1-in meatballs, and broil on a rimmed " +
    			"cookie sheet on low in the oven until cooked through.");
	fakeDirections.add("Bring pineapple juice and oil to a boil for one minute. Meanwhile, mix" +
    			"soy sauce, sugar, and vinegar together. Add to the boiling juice and " +
    			"simmer on medium until sauce thickens.");
	fakeDirections.add("Combine sauce, meatballs, and canned fruit. Serve hot over fresh rice." +
				"Can be served or warmed in crockpot as well.");
	
	return fakeDirections;
}

private static ArrayList<Ingredient> setFakeIngredients1() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 c. Cheddar Cheese, grated"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Bread Cumbs"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Curry Powder"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Mayonnaise"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("3 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);
	i = new Ingredient("2 10-oz pkg. Broccoli, frozen"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);	
	
	return fakeIngredients;
}


private static ArrayList<Ingredient> fakeIngredients = new ArrayList<Ingredient>();
private static ArrayList<Ingredient> setFakeIngredients2() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 lb. Ground Beef"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);
	i = new Ingredient("1 Egg"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Yellow Onion, chopped"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Bread Crumbs"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Salt"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 t. Pepper"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 T. Oil"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 T. Soy Sauce"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Sugar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("3 T. Apple Cider Vinegar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("15 oz. can Pineapple Tidbits"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("8 oz. Mandarin Oranges"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients3() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 can Cream of Chicken Soup"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1 can Cream of Mushroom Soup"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. White Onion"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);	
	i = new Ingredient("1 pkg. Pie Shells"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Miracle Whip"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 bag Frozen Mixed Vegetables"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);
	i = new Ingredient("2 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
	
	return fakeIngredients;
}
   
private static ArrayList<Ingredient> setFakeIngredients4() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("All-Purpse Flour, as needed"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("2 (14- to 16-oz) Pkgs All-Butter Puff Pastry, thawed"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1 Large Egg"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1 Tbs Water"); i.setCategory("OTHER");
	fakeIngredients.add(i);
	i = new Ingredient("1 lb Chicken Breast"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);
	i = new Ingredient("2 tsp Olive Oil"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("Kosher Salt"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("Freshly Ground Black Pepper"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);	
	i = new Ingredient("3 Tbs Unsalted Butter"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/3 c. Celery, finely chopped (1 medium stalk)"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/3 c. Shallot, finely chopped (1 medium stalk)"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Carrot, finely chopped (1 medium stalk)"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("3/4 c. Heavy Cream"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Chicken Stock"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 tsp. Ground Sage"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 1/2 tsp. Cornstarch"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 1/2 tsp. Water"); i.setCategory("OTHER");
	fakeIngredients.add(i);
	i = new Ingredient("1/3 c. Frozen Petite Peas, thawed"); i.setCategory("FROZEN ITEMS");
	fakeIngredients.add(i);
	i = new Ingredient("1 Tbs. Fresh Italian Parsley Leaves, coarsely chopped"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients5() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("5 links (19.5 oz.) Turkey Bratwurst"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);
	i = new Ingredient("2 tsp. Olive Oil"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("2 c. Brown Lentils"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Celery, chopped"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Carrots, chopped"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 large leek, light green and white parts chopped"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("2 Bay Leaves"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 tsp. Dried Thyme"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);	
	i = new Ingredient("8 c. Chicken Stock"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);	
	i = new Ingredient("2 T Vinegar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);	
		
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients6() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1/2 Green Bell Pepper"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 Red Bell Pepper"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 15 oz can Pineapple Tidbits"); i.setCategory("CANNED GOODS & SOUPS");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Yellow Onion"); i.setCategory("FRUITS & VEGETABLES");
	fakeIngredients.add(i);
	i = new Ingredient("1 10 oz bottle Italian dressing"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 10 oz jar Approcot jam"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Rice"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("2 Chicken Breasts"); i.setCategory("MEAT & SEAFOOD");
	fakeIngredients.add(i);	
		
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients7() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("1 pkg Brownie Mix"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c plus 2 Tbs Peanut Butter"); i.setCategory("CONDIMENTS");
	fakeIngredients.add(i);
	i = new Ingredient("2 Large Eggs"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1 c. Sugar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 tsp. Vanilla"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1/8 tsp. Salt"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("6 oz. Bittersweet Chocolate, finley chopped"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1/4 c. Heavy Cream"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);	
		
	return fakeIngredients;
}

private static ArrayList<Ingredient> setFakeIngredients8() {
	
	fakeIngredients = new ArrayList<Ingredient>();
	Ingredient i = new Ingredient("3 Tbs Cocoa Powder"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("5 oz. Semisweet Chocolate, finely chopped"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 pkg. Yellow Cake Mix"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("1 Egg"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 c. Vegetable Oil"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);	
	i = new Ingredient("1/2 c. Water"); i.setCategory("OTHER");
	fakeIngredients.add(i);	
	i = new Ingredient("1 1/3 c. Sugar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
	i = new Ingredient("5 Egg Whites"); i.setCategory("DAIRY, EGGS, & CHEESE");
	fakeIngredients.add(i);
	i = new Ingredient("1/2 Tsp. Cream of Tartar"); i.setCategory("SPICES & BAKING");
	fakeIngredients.add(i);
		
	return fakeIngredients;
}

// On List Section Fragment, This is the Expandable List Adapter
private ListExpandableListAdapter ExpListAdapter;
public ListExpandableListAdapter getListAdapter() {
	return ExpListAdapter;
}
public void setListAdapter(ListExpandableListAdapter ExpListAdapter) {
	this.ExpListAdapter = ExpListAdapter;
}

// On Meals Section Fragment, This is the Meal Adapter
private MealAdapter<Recipe> ma;
public MealAdapter<Recipe> getMealAdapter() {
	return ma;
}
public void setMealAdapter(MealAdapter<Recipe> ma) {
	this.ma = ma;
}

// 
private ImageAdapter imgAdapterLiked;
private ImageAdapter imgAdapterSaved;
private ImageAdapter imgAdapterAllRecipes;
private ImageAdapter getLikedIA() {
	return imgAdapterLiked;
}
public void setLikedIA(ImageAdapter ia) {
	this.imgAdapterLiked = ia;
}
public ImageAdapter getSavedIA() {
	return imgAdapterLiked;
}
public void setSavedIA(ImageAdapter ia) {
	this.imgAdapterLiked = ia;
}
public ImageAdapter getAllRecipesIA() {
	return imgAdapterLiked;
}
public void setAllRecipesIA(ImageAdapter ia) {
	this.imgAdapterLiked = ia;
}

//HACK
private TabPageIndicator std;
public void setSTD(TabPageIndicator std) {
	this.std = std;
}
public TabPageIndicator getSTD() {
	return std;
}
private FindRecipeActivity lstd;
public void setLSTD(FindRecipeActivity lstd) {
	this.lstd = lstd;
}
public FindRecipeActivity getLSTD() {
	return lstd;
}
private FrameLayout tutorial;
public void setTutorial(FrameLayout tutorial) {
	this.tutorial = tutorial;
}
public FrameLayout getTutorial() {
	return tutorial;
}
private RelativeLayout rl1;
public void setCartRL1(RelativeLayout rl) {
	this.rl1 = rl;
}
public RelativeLayout getCartRL1() {
	return rl1;
}
public void setRL1Visible() {
	((TextView) rl1.getChildAt(0)).setText("List: " + getUser().getTotalListItems()); //
	((TextView) rl1.getChildAt(1)).setText("Cart: " + getUser().getTotalCartItems()); //
	rl1.setVisibility(View.VISIBLE);
}
public void setRL1Gone() {
	rl1.setVisibility(View.GONE);
}
private RelativeLayout rl2;
public void setCartRL2(RelativeLayout rl2) {
	this.rl2 = rl2;
}
public RelativeLayout getCartRL2() {
	return rl2;
}
public void setRL2Visible() {
	((TextView) rl2.getChildAt(0)).setText("List: " + getUser().getTotalListItems()); //
	((TextView) rl2.getChildAt(1)).setText("Cart: " + getUser().getTotalCartItems()); //
	rl2.setVisibility(View.VISIBLE);
}
public void setRL2Gone() {
	rl2.setVisibility(View.GONE);
}
	
}
