import java.util.Scanner;       // Imports Scanner functionality
import java.util.ArrayList;     // Imports ArrayList functionality

/**
 * Program creates recipes and stores them inside recipebox.
 * 
 * @author Anthony Girod
 * @version 1.0
 */

public class Recipe {
    
    private String recipeName;
    private int servings;
    private double totalRecipeCalories;
    ArrayList<Ingredient> recipeIngredients; // Instantiates new ArrayList

    
    /** 
     * @param recipeName
     */
    // Mutators
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    
    /** 
     * @param servings
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    // Accessors
    public String getRecipeName() {
        return recipeName;
    }

    public int getServings() {
        return servings;
    }

    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    // Constructor Method
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; 
        this.recipeIngredients = new ArrayList<Ingredient>();
        this.totalRecipeCalories = 0.0;        
    }
            
    // Overloaded constructor method
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    //Override method to print string version of Recipe objects
    @Override
    public String toString() {
        
        return (this.getRecipeName());    
    }
    
    public String toStringFull() {
        
        return (this.getRecipeName() + this.getServings() + this.getRecipeIngredients() + this.getTotalRecipeCalories());
    }

    // Method that prints various elements of a recipe
    public void printRecipe() {     
        double singleServingCalories = totalRecipeCalories / servings;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Recipe: " + recipeName);
        System.out.println("Serves: " + servings);
        System.out.println("Ingredients: ");
            
        for(int i = 0; i < recipeIngredients.size(); i++) {     // Iterates through recipeIngredients ArrayList
            System.out.println(recipeIngredients.get(i).getNameOfIngredient() + " - " + recipeIngredients.get(i).getIngredientAmount() + " " + recipeIngredients.get(i).getUnitMeasurement());
        }

        System.out.println("Each serving has " + singleServingCalories + " Calories.");
    }

    // Method that prints metric recipe for Metric method
    public void printMetricRecipe() {     
        double singleServingCalories = totalRecipeCalories / servings;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Recipe: " + recipeName);
        System.out.println("Serves: " + servings);
        System.out.println("Ingredients: ");
            
        for(int i = 0; i < recipeIngredients.size(); i++) {     // Iterates through recipeIngredients ArrayList
            
            if (recipeIngredients.get(i).getUnitMeasurement().toLowerCase().equals("cups") || recipeIngredients.get(i).getUnitMeasurement().toLowerCase().equals("cup") ) { // Checks to see unitMeasurement input and changes to metric unit
                
                System.out.println(recipeIngredients.get(i).getNameOfIngredient() + " - " + 240 * recipeIngredients.get(i).getIngredientAmount() + " milliliters"); // Converts cups to metric milliliter equivalent
                break;

            } else if (recipeIngredients.get(i).getUnitMeasurement().toLowerCase().equals("ounces") || recipeIngredients.get(i).getUnitMeasurement().toLowerCase().equals("ozs") || recipeIngredients.get(i).getUnitMeasurement().toLowerCase().equals("ounce")) {
                
                System.out.println(recipeIngredients.get(i).getNameOfIngredient() + " - " + 28 * recipeIngredients.get(i).getIngredientAmount() + " grams"); // Converts ounces to metric gram equivalent
                break;
            
            } else {

                System.out.println("Nothing to convert");
                break;
            
            }
            
        }

        System.out.println("Each serving has " + singleServingCalories + " Calories.");
    }
    
    // Method that creates new Recipe from user input
    
    /**
     * Returns new Recipe object
     * @param takes no parameters
     * @return a Recipe object
     */
    public Recipe createNewRecipe() {  
        
        double totalRecipeCalories = 0;
        
        ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
        boolean addMoreIngredients = true;
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        setRecipeName(scnr.nextLine());
        
        System.out.println("Please enter the number of servings: ");
        setServings(scnr.nextInt());

        do {    // Repeats ingredient creation until users answers "no"

            System.out.println("Would you like to add ingredients? Please type Yes or No");
            String response = scnr.next();

            if (response.toLowerCase().equals("yes")) {
                
                Ingredient tempIngredient = new Ingredient();		
		        tempIngredient.createNewIngredient();
		        recipeIngredients.add(tempIngredient);
                setRecipeIngredients(recipeIngredients);
                
                
                double ingredientAmount = tempIngredient.getIngredientAmount();
                double ingredientCalories = tempIngredient.getNumberCalories();
                
                totalRecipeCalories += ingredientAmount * ingredientCalories;
                setTotalRecipeCalories(totalRecipeCalories);   

            } else {
                addMoreIngredients = false;
            }     
          
       } while (addMoreIngredients == true);       

        Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        recipe1.printRecipe();
        
       return recipe1;
    }    
}