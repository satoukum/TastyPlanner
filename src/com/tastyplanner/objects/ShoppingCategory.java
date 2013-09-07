package com.tastyplanner.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCategory implements Serializable {

	private static final long serialVersionUID = 5543500557655301047L;
	
	public String Name; // Category Name
    public int number;
    public ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    public boolean bottom = false;

    public ShoppingCategory(){
        super();
    }
    
    public ShoppingCategory(String title) {
        super();
        this.Name = title;
    }    
    
    public Boolean getBottom() {
    	return bottom;
    }
    public void setBottom(boolean bottom) {
    	this.bottom = bottom;
    }
    
    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public boolean addIngredient(Ingredient ingredient){
		return ingredientList.add(ingredient);
	}
	
	public boolean removeIngredient(Ingredient ingredient) {
		//ingredientList.remove(ingredient);
		return ingredientList.remove(ingredient);
	}
	
	public String toString() {
		return getName();
	}
    
}
