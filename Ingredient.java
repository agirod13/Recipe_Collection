import java.util.Scanner;       // Imports Scanner functionality
import java.util.ArrayList;     // Imports ArrayList functionality


public class Ingredient {

    private String nameOfIngredient;
    private int ingredientAmount;
    private int numberCalories;
    private double totalCalories;
    private String unitMeasurement;
    final int MAX_CUPS = 100; //Final creates a variable (MAX_CUPS) that cannot be changed.

            // - - - - -Acessors - - - - -
    public void setNameOfIngredient (String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;        
    }

    public void setIngredientAmount (int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
    
    public void setNumberCalories (int numberCalories) {
        this.numberCalories = numberCalories;
    }

    public void setTotalCalories (double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setUnitMeasurement (String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

        // - - - - - Mutators - - - - -
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public int getNumberCalories() {
        return numberCalories;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

            // - - - - - Constructor Method - - - - -
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.numberCalories = 0;
        this.totalCalories = 0.0;
        this.unitMeasurement = "";
    }

            // - - - - - Overloaded constructor method - - - - -
    public Ingredient(String nameOfIngredient, int ingredientAmount, int numberCalories, double totalCalories, String unitMeasurement) {
        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.numberCalories = numberCalories;
        this.totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurement;
    }
    
    public Ingredient createNewIngredient() {    //public static void main(String[] args)
        
        double totalCalories = 0;        
        

        
                         // *** nameOfIngredient Validation ***
        //-----------------------------------------------------------------------------------//
        Scanner ingredientNameScanner = new Scanner(System.in);  // Creates new scanner object
        System.out.println("Please enter the name of the ingredient: ");     // Collects user input for String variable nameOfIngredient
                      
        
        if (ingredientNameScanner.hasNext("[A-Za-z]*")) { // Checks if input is a String
            setNameOfIngredient(ingredientNameScanner.nextLine());
        } else {
            System.out.println("Please input valid ingredient name: ");
            setNameOfIngredient(ingredientNameScanner.nextLine());
            
            if (ingredientNameScanner.hasNext("[A-Za-z]*")) {
                setNameOfIngredient(ingredientNameScanner.nextLine());
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
            }
        }

                        // *** unitMeasurement Validation ***
        //-----------------------------------------------------------------------------------//                
        Scanner unitMeasurementScanner = new Scanner(System.in);
        System.out.println("Please enter unit of measurement for ingredient (e.g. cups, oz., etc.): ");     // Collects user input for String variable unitMeasurement
                         
        
        if (unitMeasurementScanner.hasNext("[A-Za-z]*")) {      // Checks if input is a String
            setUnitMeasurement(unitMeasurementScanner.nextLine());
        } else {
            System.out.println("Please input valid unit of measurement: ");
            setUnitMeasurement(unitMeasurementScanner.nextLine());

            if (unitMeasurementScanner.hasNext("[A-Za-z]*")) {
                setUnitMeasurement(unitMeasurementScanner.nextLine());
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
                
            }
        }               
            
                        // *** ingredientAmount Validation ***
        //-----------------------------------------------------------------------------------//
        Scanner ingredientAmountScanner = new Scanner(System.in);
        System.out.println("Please enter the number of " + unitMeasurement + " of " + nameOfIngredient + " we'll need (between 1 and 100): "); // Collects user input for double variable ingredientAmount
        
       
        if (ingredientAmountScanner.hasNextInt()) {     // Checks if ingredientAmountScanner is an int
           setIngredientAmount(ingredientAmountScanner.nextInt());
           
            if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {    
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
            } else {                
                System.out.println(ingredientAmount + " is not a valid number of " + unitMeasurement + "!");
                System.out.println("Please enter another number of " + unitMeasurement + " between 1 and 100: "); // Prompts user a second time for a valid input if first input is invalid
                setIngredientAmount(ingredientAmountScanner.nextInt());

                if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {              
                    System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
                } else if (ingredientAmount < 1) {
                    System.out.println(ingredientAmount + " is less than 1. Sorry you are out of attempts.");
                } else {
                    System.out.println(ingredientAmount + " is greater than 100. Sorry you are out of attempts.");
                    
                }           
            }       
        } else {
            System.out.println("Error: That is not a number. Try again.");

            if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {     
                System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
            } else {                
                System.out.println(ingredientAmount + " is not a valid number of " + unitMeasurement + "!");
                System.out.println("Please enter another number of " + unitMeasurement + " between 1 and 100: "); 
                setIngredientAmount(ingredientAmountScanner.nextInt());

                if (ingredientAmount <= MAX_CUPS && ingredientAmount >= 1) {               
                    System.out.println(ingredientAmount + " is a valid number of " + unitMeasurement + "!");
                } else if (ingredientAmount < 1) {
                    System.out.println(ingredientAmount + " is less than 1. Sorry you are out of attempts.");
                } else {
                    System.out.println(ingredientAmount + " is greater than 100. Sorry you are out of attempts.");
                    
                }           
            }
        }
       
                        // *** numberCalories Validation ***
        //-----------------------------------------------------------------------------------//
         Scanner numberCaloriesScanner = new Scanner(System.in);        // Collects user input for double variable numberCalories
         System.out.println("Please enter the number of calories per " + unitMeasurement + ": "); 
       

        if (numberCaloriesScanner.hasNextInt()) {        // Checks if input is a double
            setNumberCalories(numberCaloriesScanner.nextInt());
        } else {
            System.out.println("Please input valid calorie amount: ");
            setNumberCalories(numberCaloriesScanner.nextInt());

            if (numberCaloriesScanner.hasNextInt()) {
                setNumberCalories(numberCaloriesScanner.nextInt());
            } else {
                System.out.println("Sorry, your input is still not valid; you are out of attempts");
                
            }
        }       
      
        totalCalories = ingredientAmount * numberCalories;      // Expression that calculates totalCalories by multiplying ingredientAMount by numberCaloresPerCup
        System.out.println(nameOfIngredient + " uses " + ingredientAmount + " " +  unitMeasurement + " and has " + totalCalories + " calories.");
    
        Ingredient newIngredient = new Ingredient(nameOfIngredient, ingredientAmount, numberCalories, totalCalories, unitMeasurement);
        
        return newIngredient;
    }
}