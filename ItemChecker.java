/*
 *ItemCheckerApp.java
 *@Author Cristiano
 *13/05/2022
 */

import java.util.Arrays;
import java.util.Random;

//A class definition
public class ItemChecker{
    //Declare variables - Suitable data members (instance variables)
    private final String[] counties = {"CK", "CE", "CN", "CW", "DN", "DL", "GY", "KE", "KK", "KY", "LK", "LD", "LH",
                        "LM", "LS", "MH", "MN", "MO", "OY", "RN", "SO", "TY", "WD", "WH", "WX", "WW"};

    //Constructor
    public ItemChecker() {
    }

    //Compute methods
    //Method 1 that is used to check and validate data input from user against a predefined model
    public void IsValid(String plate) {
        // Declaring and creating suitable string builders and variables
        String[] valid = new String[100];           // Array to store the plates that are valid
        String[] notValid = new String[100];        // Array to store the plates that are not valid
        int amountValid = 0, amountNotValid = 0;    // variables to store how many items has been created that are valid/invalid
        StringBuilder sb = new StringBuilder(plate); // String builder that has plate as an argument that is the value inputted from user.
        StringBuilder model = new StringBuilder("999-AA-999999");// String builder that has a model of the suitable structure
        String sub = sb.substring(4, 6);            // String that will be used to check both letters at once as they are only valid in specific pairs
        boolean isValid = false;                    // boolean to define if the plate is valid or not

        //If statement to check the first three values inputted by the user are numbers

        //Processing

        if (Character.isDigit(sb.charAt(0)) && (Character.isDigit(sb.charAt(1))) && Character.isDigit(sb.charAt(2))) {

            //If statement to check if the fourth value is a dash (-)
            if (sb.charAt(3) == model.charAt(3)) {

                //For and if statement to check the substring against the valid values of county letters
                for (String county : counties) {
                    if (sub.equals(county)) {

                        // If statement to check if the value in digit 6 is another dash(-)
                        if (sb.charAt(6) == model.charAt(6)) {
                            //For to check all the remaining digits are numbers
                            for (int p = 7; p < plate.length(); p++) {
                                isValid = Character.isDigit(sb.charAt(p));
                                valid[amountValid] = plate; //Valid plate is stored in the valid array
                                amountValid++;

                            }//Validation for last 6 inputs is false

                            notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
                            amountNotValid++;

                        }//Validation for second - is false

                        notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
                        amountNotValid++;

                    }// Validation for counties letters is false

                    notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
                    amountNotValid++;

                }//End of first for loop

                notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
                amountNotValid++;

            }//Validation for first - is false

            notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
            amountNotValid++;

        }//Validation for the first three digits is false

        notValid[amountNotValid] = plate;//invalid plates are stored in the invalid array
        amountNotValid++;

        //Output

        // If statement to give the user the right message if it is valid
        if (isValid){
            System.out.println("The value inputted for plate is valid!");
            System.out.println(plate);
        }else{
        //If statement to give the user the message that the value is not valid and provide some insight
        // about how the structure of the plate should look like
            System.out.println("The value inputted for plate is not valid!");
            System.out.println("Just bare in mind that the allowed letters for counties are \nCK, CE, CN, CW, DN, DL,\n" +
                    "GY, KE, KK, KY, LK, LD, \nLH, LM, LS, MH, MN, MO, \nOY, RN, SO, TY, WD, WH, \nWX, WW");

            System.out.println("\nThis is what you have inputted "+plate);
            System.out.println("\nYou should input the value in the following model NNN-LL-NNNNNN," +
                    " where Ls are valid county letters and N are numbers!");
        }// End of else statement

    }//End of isValid method

    //Question 2 code to generate UserIds
    public void GenerateId(int numItems){ // Method to create random User Ids getting the value inputted by the user as argument
        //Declare variables
        int itemsGenerated = 0;//Variable to track how many ids where generated so far
        String[] idArray; // Array to store the userIds generated
        idArray = new String[numItems];//Instance of id array with the amount of items specified by the user

        //Processing

        // Do while to run the piece of code until the amount specified is generated
        do {
            // Limits of random characters to be generated
            int limit1 = 97; // value of lower case a
            int limit2 = 122; // value of lower case z

            // Declare and create objects
            Random random = new Random();                                //Instance of Random object
            StringBuilder sb = new StringBuilder(5);             //Instance of a String builder
            // For used to generate the 5 letters of  the UserId
            for (int i = 0; i < 5; i++) {
                int randomLimitedInt = limit1 + (int)
                        (random.nextFloat() * (limit2 - limit1 + 1));

                //Appending the string builder 5 times for all the characters generated
                sb.append((char) randomLimitedInt);

            }// End of for
            //Converting the string builder to a string
            String letters = sb.toString();

            // Second part of the code to generate the random number from an array of elements

            char[] chars = "13579".toCharArray(); // Instance of a char array with the values that are valid
            Random rnd = new Random();            // Second instance of random method to work with the digits
            StringBuilder sb2 = new StringBuilder((100000 + rnd.nextInt(900000)));

            //For statement to generate and store the digits in the instance of the string builder
            for (int p = 0; p < 3; p++) {
            //Appending the value of the string builder 3 times
                sb2.append(chars[rnd.nextInt(chars.length)]);
            }
            //Converting the string builder in a string
            String code = sb2.toString();
            //Creating a string which is made of both the letters and numbers
            String userId = letters + code;
            //Storing the value of the generated userId into the idArray
            idArray[itemsGenerated] = userId;
            //Incrementing the value of generating items
            itemsGenerated++;

        }while(itemsGenerated<numItems); //End of do/while, when num generated equals to num that the user specified.

        //Output

        //Printing the value of the array with all the generated UserIds
        System.out.println(Arrays.toString(idArray));
    }//End of GenerateId method
}//Class


