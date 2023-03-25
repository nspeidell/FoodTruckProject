package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private int MAX_TRUCKS = 5;
	private FoodTruck[] fleet;
	private int truckCount = 0;

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();
	}

	public void run() {
		addTruck();

		int menuSelection;
		do {
			menu();
			Scanner kb = new Scanner(System.in);
			menuSelection = kb.nextInt();
			if (menuSelection == 1) {
				allTrucks();
			} else if (menuSelection == 2) {
				calcAvg();
			}

			else if (menuSelection == 3) {
				selectHighest();
			} else if (menuSelection == 4) {
				System.out.println("You have opted to quit, goodbye");
				break;
			} else {
				System.out.println("Not a valid answer");
			}
		} while (menuSelection != 4);
	}

	public void addTruck() {

		fleet = new FoodTruck[MAX_TRUCKS];

		do {
			Scanner kb = new Scanner(System.in);
			System.out.println(
					"Enter the name of the food truck, or enter quit if you do not want to enter any more trucks");
			String nm = kb.nextLine();
			if (nm.equals("quit")) {
				System.out.println("You decided to not enter anymore trucks");
				System.out.println();
				break;
			}
			System.out.println("Enter the type of food from the food truck");
			String ft = kb.nextLine();
			System.out.println("rate the food truck 1-5");
			int nr = kb.nextInt();
			fleet[truckCount] = new FoodTruck(nm, ft, nr);
			truckCount++;
			if (truckCount == MAX_TRUCKS) {
				System.out.println("You've reached the max amount of trucks to rate");
				System.out.println();
			} else {
			}
		} while (truckCount < MAX_TRUCKS);
	}

	public void selectHighest() {
		FoodTruck highTruck = new FoodTruck();

		for (FoodTruck truck : fleet) {
			if (truck != null) {
				if (truck.getNumericRating() > highTruck.getNumericRating()) {
					highTruck = truck;
				} else {
					break;
				}
			}
		}
		System.out.println(highTruck);

	}

	public void calcAvg() {
		double count = 0.0;
		double sum = 0.0;

		for (FoodTruck trucks : fleet) {
			if (trucks != null) {
				count += 1;
				sum += trucks.getNumericRating();
			}
		}
		System.out.println();
		System.out.println("The average food truck rating is: " + sum / count);
		System.out.println();
	}

	public void menu() {

		System.out.println("******************* Menu ************************");
		System.out.println("Press 1: List all existing food trucks");
		System.out.println("Press 2: See the average rating of food trucks");
		System.out.println("Press 3: highest-rated food truck");
		System.out.println("Press 4: Quit");
	}

	public void allTrucks() {
		for (FoodTruck trucks : fleet) {
			if (trucks != null) {
				trucks.displayTruck();
				System.out.println();
			} else {
			}
		}
	}
}
