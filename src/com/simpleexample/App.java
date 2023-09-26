package com.simpleexample;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
	
	private int vehicleId;

	public Vehicle(int vehicleId) {
		super();
		this.vehicleId = vehicleId;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + "]";
	}
	
	void info() {
		System.out.println("Vehicle ID is " + getVehicleId());
	}
	
}

class Car extends Vehicle {

	private String carModel;

	public Car(int vehicleId, String carModel) {
		super(vehicleId);
		this.carModel = carModel;
	}

	public String getCarModel() {
		return carModel;
	}

	@Override
	public String toString() {
		return "Car [carModel=" + carModel + "]";
	}
	
	@Override
	void info() {
		System.out.println("Car Model is " + getCarModel());
	}
	
}

public class App {

	public static void main(String[] args) {
		/*
		 * First example only object class Vehicle and the child class
		 */
		List<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle(10));
		list.add(new Vehicle(11));
		list.add(new Vehicle(12));
		list.add(new Vehicle(13));
		list.add(new Car(14, "A14"));
		display(list);
		System.out.println("===================================");
		/*
		 * Second example containing all object
		 */
		List<Object> secondlist = new ArrayList<>();
		secondlist.add("Start");
		secondlist.add(new Vehicle(23));
		secondlist.add(new Vehicle(24));
		secondlist.add(new Vehicle(25));
		secondlist.add(new Vehicle(26));
		secondlist.add(new Car(27, "S27"));
		secondlist.add(true);
		secondlist.add(false);
		secondlist.add("Finish");
		display(secondlist);
		System.out.println("===================================");
		/*
		 * Third example about upper bound
		 * restriction on parent's class
		 * upper bound means it's only accept either class or child class
		 */
		secondDisplay(list);
		System.out.println("===================================");
		/*
		 * Fourth example about lower bound
		 * restriction on child class
		 * lower bound it's means only super class of class Car
		 */
		thridDisplay(list);
		System.out.println("===================================");
		implementInfo(list);
	}
	
	public static void display(List<?> list) {
		for(Object element: list) {
			System.out.println(element);
		}
	}
	
	//Example of Upper bound
	public static void secondDisplay(List<? extends Vehicle> list) {
		for(Vehicle element: list) {
			System.out.println(element);
		}
	}
	
	//Example Lower bound
	public static void thridDisplay(List<? super Car> list) {
		for(Object element: list) {
			System.out.println(element);
		}
	}
	
	//Restriction using Upper Bound
	public static void implementInfo(List<? extends Vehicle> list) {
		for(Vehicle element: list) {
			element.info();
		}
	}
}
