/*
* Motorcycle.java
* @author Cristiano
* 03/4/2022
*/
public class Motorcycle{
	// Declare class members/ instance variables -- properties/ atributtes
	private String model; // to store the model
	private double mileage; // to store the mileage of the motorcycle
	private int year; // to store the year of manufacturing of the motorcycle

	public Motorcycle(){
	}

	public Motorcycle(String model, double mileage, int  year){
		this.model = model; // Filling the model atribute on motorcycle.
		this.mileage = mileage; // Filling the Mileage atribute on motorcycle.
		this.year = year; // Filling the year atribute on Motorcycle.
	}
	// How it will be displayed when displayState() is be called.
	public void displayState(){
		System.out.println("Model: " + model);
		System.out.println("Mileage: " + mileage + " kms");
		System.out.println("Year: " + year);
	}
	// Getters

	public String getModel(){
		return model;
	}

	public double getMileage(){
		return mileage;
	}

	public int getYear(){
		return year;
	}

	// setters

	public void setModel(String model){
		this.model = model;
	}

	public void setMileage(double mileage){
		this.mileage = mileage;
	}

	public void setYear(int year){
		this.year = year;
	}
}