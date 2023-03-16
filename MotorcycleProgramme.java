/*
* MotorcycleProgramme.java
* @author Cristiano
* 03/4/2022
*/

public class MotorcycleProgramme{
	// Declare variables
	private Motorcycle [] theMotorcycles;

	// Constructor
	public MotorcycleProgramme(Motorcycle[] motorcycles){
		this.theMotorcycles = motorcycles;
	}
	// Compute methods
	public void computeAverage(int size){
		double sum = 0, avg = 0;
		System.out.println("The average of the mileages is: ");
								for(int i = 0; i < size; i++){
									sum = sum + theMotorcycles[i].getMileage();
					}// End of the for loop

								avg = sum/size;
						System.out.println(avg + " kms");
	}
	public void computeHighest(int size){
		int index = 0;
		double highest = 0;
		for(int i = 0; i < size; i++){
									if(theMotorcycles[i].getMileage()>= highest){
										highest = theMotorcycles[i].getMileage();
										index = i;
					}
					}
			System.out.println("The motorcycle with the highest mileage inputted so far is the motorcycle: " + (index+1));
			theMotorcycles[index].displayState();
		}


	public void computeSearch(int size, double search){
		int track = 0;
		for(int i = 0; i < size; i++){
			track = 0;
			if (search == theMotorcycles[i].getMileage()){
				track=1;
				System.out.println("Motorcycle: " + (i+1));
				theMotorcycles[i].displayState();
			}//End of if statement
		}//End of for loop
			if(track==0){
				System.out.println("\nNot a single item matches your search");
				track = 0;
			}
		}

}