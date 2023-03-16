/*
*ItemCheckerApp.java
*@author Author Cristiano
*13/05/2022
*/
import java.util.Scanner;

public class ItemCheckerApp{
    public static void main(String[] args) {

		//Declare variables
		String yesOrNo;

		//Declare and create objects
		Scanner sc = new Scanner(System.in);
       	ItemChecker myIC = new ItemChecker();

	   	//Question 1, Checking Irish registration plates


		do {
		//Declaring local variable for this case
			String plate;  //Plate variable that will only be used in question 1 and method 1

			//Input

			System.out.println("Please enter the plate you would like to check");
			do {

				plate = sc.nextLine();
				if (plate.length() >= 7 && (plate.length() <= 13)) {
					plate = plate.toUpperCase();
				} else {
					System.out.println("Plate value should have between 7 and 13 characters and should follow the  model NNN-LL-NNNNNN," +
							" where Ls are letters and N are numbers!");
				}
			} while ((plate.length() < 7) || (plate.length() > 13));

		//Processing and output of valid or not

			myIC.IsValid(plate);

		// Output of wanting to continue checking or not!

			System.out.println("\nWould you like to check another plate? yes or no");
			yesOrNo = sc.nextLine();
		}while(yesOrNo.equals("yes"));
		System.out.println("Bye!");


		//End of question 1
/*
	 	// All question 2 code is commented as requested and will not be executed until it is changed
		// Question 2, UserId Generator


		do {
		// Declaring local variables that will be used for this case.
			int ids=0; // Local variable that will only be used in case 2 and method 2

			//INPUT

			System.out.println("Please enter the number of ids you want to generate!");
			ids = sc.nextInt();

			//Processing and output of generated IDS

			myIC.GenerateId(ids);

			//Output of user choice to generate more ids or exit

			System.out.println("\nWould you like generate more Ids? yes or no");
			yesOrNo = sc.next();
		}while(yesOrNo.equals("yes"));//End of do/while for question 2
		System.out.println("Bye!");
*/
	}//main
}//class