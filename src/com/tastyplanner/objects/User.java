package com.tastyplanner.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 5543500557655301047L;
	
	private String Name;
	private String Username;
	private String Fbloginid;
	private String Email;
	private ArrayList<User> FollowerList = new ArrayList<User>();
	private ArrayList<User> FollowingList = new ArrayList<User>();
	private ArrayList<Recipe> FavoriteRecipesList = new ArrayList<Recipe>();
	private ArrayList<Recipe> PinnedRecipesList = new ArrayList<Recipe>();
	private ArrayList<Recipe> MealRecipesList = new ArrayList<Recipe>();
	private ArrayList<Recipe> PastRecipesList = new ArrayList<Recipe>();
	private ArrayList<ShoppingCategory> ShoppingList = new ArrayList<ShoppingCategory>();	

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getFbloginid() {
		return Fbloginid;
	}
	public void setFbloginid(String fbloginid) {
		Fbloginid = fbloginid;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public ArrayList<User> getFollowerList() {
		if (FollowerList == null) {
			FollowerList = new ArrayList<User>();
		}
		
		return FollowerList;
	}
	public void setFollowerList(ArrayList<User> followerList) {
		FollowerList = followerList;
	}
	public ArrayList<User> getFollowingList() {
		if (FollowingList == null) {
			FollowingList = new ArrayList<User>();
		}
		
		return FollowingList;
	}
	public void setFollowingList(ArrayList<User> followingList) {
		FollowingList = followingList;
	}
	
	
	public ArrayList<Recipe> getFavoriteRecipesList() {
		if (FavoriteRecipesList == null) {
			FavoriteRecipesList = new ArrayList<Recipe>();
		}
		
		return FavoriteRecipesList;
	}
	public void setFavoriteRecipesList(ArrayList<Recipe> favoriteRecipesList) {
		FavoriteRecipesList = favoriteRecipesList;
	}
	
	
	public ArrayList<Recipe> getPinnedRecipesList() {
		if (PinnedRecipesList == null) {
			PinnedRecipesList = new ArrayList<Recipe>();
		}
		
		return PinnedRecipesList;
	}
	public void setPinnedRecipesList(ArrayList<Recipe> pinnedRecipesList) {
		PinnedRecipesList = pinnedRecipesList;
	}
	public ArrayList<Recipe> getMealRecipesList() {
		if (MealRecipesList == null) {
			MealRecipesList = new ArrayList<Recipe>();
		}
		
		return MealRecipesList;
	}
	public void setPastRecipesList(ArrayList<Recipe> PastRecipesList) {
		this.PastRecipesList = PastRecipesList;
	}
	public ArrayList<Recipe> getPastRecipesList() {
		if (PastRecipesList == null) {
			PastRecipesList = new ArrayList<Recipe>();
		}
		
		return PastRecipesList;
	}
	public void setMealRecipesList(ArrayList<Recipe> mealRecipesList) {
		MealRecipesList = mealRecipesList;
	}
	
	public ArrayList<ShoppingCategory> getShoppingList() {
		return ShoppingList;
	}
	public void setShoppingList(ArrayList<ShoppingCategory> shoppingList) {
		ShoppingList = shoppingList;
	}

	public String toString() {
		return getName();
	}
	
	public void setShoppingList() {
		ShoppingCategory sc = new ShoppingCategory("FRUITS & VEGETABLES");
		sc.setNumber(1);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("DAIRY, EGGS, & CHEESE");
		sc.setNumber(2);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("SPICES & BAKING");
		sc.setNumber(3);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("CONDIMENTS");
		sc.setNumber(4);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("MEAT & SEAFOOD");
		sc.setNumber(5);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("CANNED GOODS & SOUPS");
		sc.setNumber(6);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("FROZEN ITEMS");
		sc.setNumber(7);	
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("OTHER");
		sc.setNumber(8);
		ShoppingList.add(sc);
		
		// room for regular items
		
		sc = new ShoppingCategory("PRETEND");
		sc.setNumber(9);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("FRUITS & VEGETABLES ");
		sc.setNumber(11);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("DAIRY, EGGS, & CHEESE ");
		sc.setNumber(12);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("SPICES & BAKING ");
		sc.setNumber(13);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("CONDIMENTS ");
		sc.setNumber(14);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("MEAT & SEAFOOD ");
		sc.setNumber(15);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("CANNED GOODS & SOUPS ");
		sc.setNumber(16);
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("FROZEN ITEMS ");
		sc.setNumber(17);	
		ShoppingList.add(sc);
		
		sc = new ShoppingCategory("OTHER ");
		sc.setNumber(18);
		ShoppingList.add(sc);
		
		/**
		sc = new ShoppingCategory("REGULAR ITEMS");
		sc.setNumber(9);
		sc.addIngredient(new Ingredient("1 gal. Milk")); // TODO allow user to pick...	
		ShoppingList.add(sc);
		*/
		
		
		
	}
	
	//TODO
	private int totalListItems = 0;
	public int getTotalListItems() {
		return totalListItems;
	}
	public void setTotalListItems(int totalListItems) {
		this.totalListItems=totalListItems;
	}
	public void incrementTotalListItems() {
		totalListItems +=1;
	}
	public void decrementTotalListItems() {
		totalListItems -=1;
	}
	private int totalCartItems = 0;
	public int getTotalCartItems() {
		return totalCartItems;
	}
	public void setTotalCartItems(int totalCartItems) {
		this.totalCartItems=totalCartItems;
	}
	public void incrementTotalCartItems() {
		totalCartItems +=1;
	}
	public void decrementTotalCartItems() {
		totalCartItems -=1;
	}
	
	public void addToHarted(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setHarted(true);
		getFavoriteRecipesList().add(DataSingleton.getInstance().getRecipes().get(theUUID));
	}
	public void removeFromHarted(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setHarted(false);
		getFavoriteRecipesList().remove(DataSingleton.getInstance().getRecipes().get(theUUID));
	}
	
	public void addToPinned(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setPinned(true);
		getPinnedRecipesList().add(DataSingleton.getInstance().getRecipes().get(theUUID));
	}
	public void removeFromPinned(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setPinned(false);
		getPinnedRecipesList().remove(DataSingleton.getInstance().getRecipes().get(theUUID));
	}

	
	public void addToMeals(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setPlanned(true);
		MealRecipesList.add(DataSingleton.getInstance().getRecipes().get(theUUID));
		for (Ingredient ingre : DataSingleton.getInstance().getRecipes().get(theUUID).getIngredientList()) {    		
			for (ShoppingCategory shopcat : ShoppingList) {
				if (shopcat.getName().equals(ingre.getCategory())) {
					ingre.setStriked(false);
					shopcat.addIngredient(ingre);
					totalListItems += 1; //TODO
				}
			}    		
		}
	}
	public void removeFromMeals(java.util.UUID theUUID) {
		DataSingleton.getInstance().getRecipes().get(theUUID).setPlanned(false);
		MealRecipesList.remove(DataSingleton.getInstance().getRecipes().get(theUUID));
		for (Ingredient ingre : DataSingleton.getInstance().getRecipes().get(theUUID).getIngredientList()) {    		
			for (ShoppingCategory shopcat : ShoppingList) {
				if (shopcat.getName().equals(ingre.getCategory())) {
					ingre.setStriked(false);
					
					// TODO
					// have to return true if the ingredient is found
					// otherwise the user has already cleared the ingredient
					if (shopcat.removeIngredient(ingre)) {
						 if (shopcat.getNumber() < 10) {
							 totalListItems -= 1; //TODO check
						 } else {
							 ingre.setCategory(ingre.getCategory().trim());
							 totalCartItems -= 1;
						 }
					}
				}
			}    		
		}
	}
	
	public void setDefaultMeals() {
		addToMeals(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39"));
		addToMeals(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f"));
		addToMeals(java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb"));
		addToMeals(java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda"));
		
	}
	
	public void setDefaultLikedMeals() {
    	addToHarted(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f35"));
    	addToHarted(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f34"));
    	addToHarted(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f33"));
    	addToHarted(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32"));
	}
	
	public void setDefaultPinnedMeals() {
		addToPinned(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39"));
		addToPinned(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f"));
    	addToPinned(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32"));
	}
	
	// TODO finish
	// More than just one list
	public void setPastRecipes() {
		addToPast(java.util.UUID.fromString("78c12828-55d6-48dd-9f5f-0af37865b33f"));
		addToPast(java.util.UUID.fromString("e7a004cf-a110-4652-9dd2-ac2cea285feb"));
		addToPast(java.util.UUID.fromString("968e212f-a7e4-4fa6-98b8-dece3bcf1eda"));	
		addToPast(java.util.UUID.fromString("c4a32e87-f664-439a-a6f9-da3e4af81f39"));
    	addToPast(java.util.UUID.fromString("c5a32e87-f664-439a-a6f9-da3e4af81f32"));
	}
	public void addToPast(java.util.UUID theUUID) {
		PastRecipesList.add(DataSingleton.getInstance().getRecipes().get(theUUID));
	}
	public void removeFromPast(java.util.UUID theUUID) {
		PastRecipesList.remove(DataSingleton.getInstance().getRecipes().get(theUUID));
	}
	
}
