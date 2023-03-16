/*
* MotorcycleApp.java
* @author Cristiano
* 03/4/2022
*/

import java.util.Scanner;

public class MotorcycleApp {

	public static void main(String[] args) {
		// Declaring variables
		String model; 								// Motorcycle class variable
		double mileage; 							// Motorcycle class variable
		int year = 0; 								// Motorcycle class variable

		String message;								// Variable to prompt a message if the user try any action before adding something
		String validation;							// Variable used to validate only numbers for menu.
		Motorcycle[] theMotorcycles;				// A variable to work with a 1D array of Motorcycle objects.
		int option = 0; 							// Variables to control the action the user will get and if he wants to continue.
		int numMotorcycles=0; 			// The number of motorcycles already added and variable  to control indexes
		int itemsRemaining=5, track = 0;			// Variables to show remaining items and track display in case 3
		final int max_Num_Items=5; 					// the number of motorcycles that can be added
		double search; 								// Variable to allow the user to insert a search for mileage on the motorcycles array

		//Defining the message the user will get if he tries any other action than Add item or Exit as soon as the application runs
		message = "\nYou have not added anything yet";

		// Instantiate the motorcycle array
		theMotorcycles = new Motorcycle [max_Num_Items];

		//Declare a motorcycle object to act as a placeholder for the user input
		Motorcycle m;

		// Creating Scanner Object
		Scanner sc = new Scanner(System.in);

		//Creating an instance of MotorcycleProgramme
		MotorcycleProgramme mp = new MotorcycleProgramme(theMotorcycles);


		// Whole body of the program that will be run until  the user decides to quit.
		do{

		//Reseting the value of option every time the program runs to avoid repetition of previous commands.
			option = 0;

		//Menu displayed

		System.out.println("Application Menu - Motorcycles \n"
			+ "Input a maximum of " + max_Num_Items + "  items \n"
			+ "Note that you can input " + (itemsRemaining) + " more items \n"
			+ "1 - Add Item \n"
			+ "2 - Display all items \n"
			+ "3 - Search for mileage \n"
			+ "4 - Average of mileage so far \n"
			+ "5 - Motorcycle with highest mileage \n"
			+ "6 - Exit application \n");
		//End of menu

		// Getting information about what the user want to do
			System.out.println("Select your option");
			validation = sc.next();
			//If statement to only allow the user to input valid values on the menu screen, these being 1 to 6

			if(validation.equals("1")|| validation.equals("2")|| validation.equals("3")|| validation.equals("4")|| validation.equals("5")|| validation.equals("6")){
				option = Integer.parseInt(validation);
				validation = "zero";
				}else{
					System.out.println("\nYou should input a value corresponding to the menu 0 to 6");
					validation = "0";
		}
			//End of validation for input on menu screen


			//Selection action through the user input
				switch(option) {
				case 1://Adding objects case

			//Validating the number of already added not bigger than maximum allowed
					if(numMotorcycles < max_Num_Items){
			// Adding motorcycles process starting

						System.out.println("Entry is starting");
						System.out.println("Enter details for motorcycles " + (numMotorcycles+1));

						System.out.println("Please enter the motorcycle model");
						model = sc.next();

			// Do while to validate the input for mileage from the user as it should always be a positive number
						do{
						System.out.println("Please enter the motorcycle mileage");
						mileage = sc.nextDouble();
						if (mileage<0){
						System.out.println("Please enter a positive number for motorcycle mileage");
			}//End of if statement
						}while(mileage<0);
			// End of validation for mileage


			// Do while to validate the input for year from the user as it should always be a positive number
						do{
						System.out.println("Please enter the motorcycle year");
						year = sc.nextInt();
						if (year<0){
						System.out.println("Please enter a valid value for the motorcycle year");
			}// End of If Statement
						}while (year<0);
			// End of validation for year input

			//Instantiating a motorcycle object
						m = new Motorcycle(model, mileage, year);

			// Add created motorcycle object to the motorcycle array
						theMotorcycles[numMotorcycles] = m;
						numMotorcycles++;
						itemsRemaining--;

			}// End of return from main if statement being true
						else{
						System.out.println("You already inputed all the allowed items");
			}// end of if statement
				System.out.println("\n");
				break; // End of case 1


				case 2://Displaying all objetcs already added Case

			// Printing all the already inputed motorcycles
			// If statement to prompt a message if display is invoked before inputing something
						if(numMotorcycles == 0){
						System.out.println(message);
			}//End of condition being true
						else {
						for(int i = 0; i < numMotorcycles; i++){
						System.out.println("Motorcycles details: ");
						theMotorcycles[i].displayState();
			}// End of if statement
			}// End of For Loop
				System.out.println("\n");
				break;// End of case 2


				case 3:// Search mileage case

			// If statement to prompt a message if search is invoked before inputing something
				if (numMotorcycles==0){
					System.out.println(message);
					}else{
			//Getting the value of the mileage the user want to look for
			//Validating the input for mileage
						do{
						search = 0;
						System.out.println("Please insert the mileage you are looking for");
						search = sc.nextDouble();
						if (search<0){
							System.out.println("Please enter a positive number for motorcycle mileage");
			}// End of if Statement

					}while (search<0);

			// End of validation
			// Starting the search for the desired mileage
			mp.computeSearch(numMotorcycles, search);

			}//End of main if statement
				System.out.println("\n");
				break;// End of case 3


				case 4:// Average mileage case

			// If statement to prompt a message if average is invoked before inputing something
						if(numMotorcycles == 0){
						System.out.println(message);

			}//End of condition being true
						else{
						mp.computeAverage(numMotorcycles);

			}// End of the if statement
				System.out.println("\n");
				break;//End of case 4


				case 5: // Details of highest Mileage case

			// If statement to prompt a message if highest mileage is invoked before inputing something

						if(numMotorcycles == 0){
						System.out.println(message);
			}//End of first if condition being true

						else{
							mp.computeHighest(numMotorcycles);
						}// End of the if statement
				System.out.println("\n");


				break;// End of case 5


				case 6://Exit case

					System.out.println("Bye!");
					System.exit(1);

				break;
			//Printing a message if the user input an invalid value
				default:
				System.out.println("\n");
			}//End of Switch case


		}while (option != 6);// End of Do while loop
	}// Main
}// Class