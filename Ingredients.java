import java.util.Scanner;


public class Ingredients {
    public static void main(String[] args) {
        String nameOfIngredient =  "";
        double ingredientAmount = 0.0;
        double numberCalories = 0.0;
        double totalCalories = 0.0;
        String unitMeasurement = "";
        final int MAX_CUPS = 100; //Final creates a variable (MAX_CUPS) that cannot be changed.


                         // *** nameOfIngredient Validation ***
        //-----------------------------------------------------------------------------------//
        System.out.println("Please enter the name of the ingredient: ");     // Collects user input for String variable nameOfIngredient
        Scanner ingredientNameScanner = new Scanner(System.in);  // Creates new scanner object               
        
        if (ingredientNameScanner.hasNext("[A-Za-z]*")) { // Checks if input is a String
            nameOfIngredient = ingredientNameScanner.next();
        } else {
            System.out.println("Please input valid ingredient name: ");
            nameOfIngredient = ingredientNameScanner.next();
            
            if (ingredientNameScanner.hasNext("[A-Za-z]*")) {
                nameOfIngredient = ingredientNameScanner.next();
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
                return;
            }
        }

                        // *** unitMeasurement Validation ***
        //-----------------------------------------------------------------------------------//                
        System.out.println("Please enter unit of measurement for ingredient (e.g. cups, oz., etc.): ");     // Collects user input for String variable unitMeasurement
        Scanner unitMeasurementScanner = new Scanner(System.in);                 
        
        if (unitMeasurementScanner.hasNext("[A-Za-z]*")) {      // Checks if input is a String
            unitMeasurement = unitMeasurementScanner.next();
        } else {
            System.out.println("Please input valid unit of measurement: ");
            unitMeasurement = unitMeasurementScanner.next();

            if (unitMeasurementScanner.hasNext("[A-Za-z]*")) {
                unitMeasurement = unitMeasurementScanner.next();
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
                return;
            }
        }               
            
                        // *** ingredientAmount Validation ***
        //-----------------------------------------------------------------------------------//
        System.out.println("Please enter the number of " + unitMeasurement + " of " + nameOfIngredient + " we'll need (between 1 and 100): "); // Collects user input for double variable ingredientAmount
        Scanner ingredientAmountScanner = new Scanner(System.in);
       
        if (ingredientAmountScanner.hasNextDouble()) {     // Checks if ingredientAmountScanner is a double
           ingredientAmount = ingredientAmountScanner.nextDouble();
           
            if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {    
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
            } else {                
                System.out.println(ingredientAmount + " is not a valid number of " + unitMeasurement + "!");
                System.out.println("Please enter another number of " + unitMeasurement + " between 1 and 100: "); // Prompts user a second time for a valid input if first input is invalid
                ingredientAmount = ingredientAmountScanner.nextDouble();

                if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {              
                    System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
                } else if (ingredientAmount < 1) {
                    System.out.println(ingredientAmount + " is less than 1. Sorry you are out of attempts.");
                } else {
                    System.out.println(ingredientAmount + " is greater than 100. Sorry you are out of attempts.");
                    return;
                }           
            }       
        } else {
            System.out.println("Error: That is not a number. Try again.");

            if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {     
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
            } else {                
                System.out.println(ingredientAmount + " is not a valid number of " + unitMeasurement + "!");
                System.out.println("Please enter another number of " + unitMeasurement + " between 1 and 100: "); 
                ingredientAmount = ingredientAmountScanner.nextDouble();

                if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {               
                    System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
                } else if (ingredientAmount < 1) {
                    System.out.println(ingredientAmount + " is less than 1. Sorry you are out of attempts.");
                } else {
                    System.out.println(ingredientAmount + " is greater than 100. Sorry you are out of attempts.");
                    return;
                }           
            }
        }
       
                        // *** numberCalories Validation ***
        //-----------------------------------------------------------------------------------//
        System.out.println("Please enter the number of calories per " + unitMeasurement + ": "); 
        Scanner numberCaloriesScanner = new Scanner(System.in);        // Collects user input for double variable numberCalories

        if (numberCaloriesScanner.hasNextDouble()) {        // Checks if input is a double
            numberCalories = numberCaloriesScanner.nextDouble();
        } else {
            System.out.println("Please input valid calorie amount: ");
            numberCalories = numberCaloriesScanner.nextDouble();

            if (numberCaloriesScanner.hasNextDouble()) {
                numberCalories = numberCaloriesScanner.nextDouble();
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
                return;
            }
        }       
      
        totalCalories = ingredientAmount * numberCalories;      // Expression that calculates totalCalories by multiplying ingredientAMount by numberCaloresPerCup
        System.out.println(nameOfIngredient + " uses " + ingredientAmount + " " +  unitMeasurement + " and has " + totalCalories + " calories.");
    }
}