package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	//fields for trucks
	private String name;
	private int uniqueId;
	private static int increment = 100;
	private String foodType;
	private int numericRating;
	
	public FoodTruck() {

	}
	public FoodTruck(String name, String foodType, int numericRating) {
		this.name = name;
		this.foodType = foodType;
		this.numericRating = numericRating;
		this.uniqueId = increment++;
	}
	

	@Override
	public String toString() {
		return "FoodTruck [name=" + name + ", uniqueId=" + uniqueId + ", foodType=" + foodType + ", numericRating="
				+ numericRating + "]";
	}
	  public void displayTruck() {
		    String truckData = this.toString();
		    System.out.println(truckData);
	  
		    }
	  public void calcAvg() {
		  
	  }
	  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(int numericRating) {
		this.numericRating = numericRating;
	}

}
