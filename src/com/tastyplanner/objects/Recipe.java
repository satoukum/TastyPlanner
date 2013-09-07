package com.tastyplanner.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Conversation Object
 * @author Marissa.Nielsen
 *
 */
public class Recipe implements Serializable {

	private static final long serialVersionUID = 5543500557655301047L;

	private UUID UUID;
	private String Name;
	private ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();
	private ArrayList<String> DirectionsList = new ArrayList<String>();
	private double ReadyInHours;
	private int ReadyInMinutes;
	private double Servings;
	private int imageResource;
	
	public Recipe() {
		//do nothing
	}
	
	public Recipe(String name, int imageResource, UUID UUID) {
		this.Name = name;
		this.imageResource = imageResource;
		this.UUID = UUID;
	}
	
	public Recipe(String string) {
		this.Name = string;
	}
	
	private boolean isHarted = false;
	public void setHarted(boolean isHarted) {
		this.isHarted = isHarted;
	}
	public boolean getHarted() {
		return isHarted;
	}
	private boolean isPinned = false;
	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}
	public boolean getPinned() {
		return isPinned;
	}
	private boolean isPlanned = false;
	public void setPlanned(boolean isPlanned) {
		this.isPlanned = isPlanned;
	}
	public boolean getPlanned() {
		return isPlanned;
	}

	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public ArrayList<Ingredient> getIngredientList() {
		return IngredientList;
	}



	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		IngredientList = ingredientList;
	}



	public ArrayList<String> getDirectionsList() {
		return DirectionsList;
	}



	public void setDirectionsList(ArrayList<String> directionsList) {
		DirectionsList = directionsList;
	}



	public double getReadyInHours() {
		return ReadyInHours;
	}



	public void setReadyInHours(double readyInHours) {
		ReadyInHours = readyInHours;
	}



	public int getReadyInMinutes() {
		return ReadyInMinutes;
	}



	public void setReadyInMinutes(int readyInMinutes) {
		ReadyInMinutes = readyInMinutes;
	}



	public double getServings() {
		return Servings;
	}



	public void setServings(double servings) {
		Servings = servings;
	}
	
	public UUID getUUID() 
	{
		return UUID;
	}
	public void setUUID(UUID UUID) {
		this.UUID = UUID;
	}
	
	public int getImageResource() {
		return imageResource;
	}
	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	/**
	 * ToString Method :)
	 */
	public String toString() {
		return getName();
	}


}