package com.tastyplanner.objects;

import java.io.Serializable;

public class Ingredient implements Serializable {

	private static final long serialVersionUID = 5543500557655301047L;

    public String Title; // List item
    public boolean Striked = false;
    public String Category;
    public String Tag;
	
    public Ingredient(){
        super();
    }
    
    public Ingredient(String title) {
        super();
        this.Title = title;
    }	
    
    public void setTitle(String title) {
    	this.Title = title;
    }
    public String getTitle() {
    	return Title;
    }
	
    public void setStriked(boolean striked) {
    	this.Striked=striked;
    } 
    public boolean getStriked() {
    	return Striked;
    }
    
    public void setCategory(String category) {
    	this.Category=category;
    }
    public String getCategory() {
    	return Category;
    }
    
	public String getTag() {
		return Tag;
	}
	public void setTag(String Tag) {
		this.Tag = Tag;
	}
	
	public String toString() {
		return getTitle();
	}
    
}
