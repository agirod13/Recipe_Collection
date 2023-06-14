import java.util.Scanner;       // Imports Scanner functionality
import java.util.ArrayList;     // Imports ArrayList functionality

public class Recipe {
    
    private String recipeName;
    private int servings;
    private double totalRecipeCalories;
    ArrayList<String> recipeIngredients; // Instantiates new ArrayList

            //- - - - - Accessors - - - - -
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setTotalRecipeCalories( double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
            //- - - - - Mutators - - - - -
    public String getRecipeName() {
        return recipeName;
    }

    public int getServings() {
        return servings;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

            //- - - - - Constructor Method - - - - -
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; 
        this.recipeIngredients = new ArrayList<String>();
        this.totalRecipeCalories = 0.0;        
    }
            
            // - - - - - Overloaded constructor method - - - - -
    public Recipe(String recipeName, int servings, ArrayList<String> recipeIngredients, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

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
            System.out.println(recipeIngredients.get(i));
        }

        System.out.println("Each serving has " + singleServingCalories + " Calories.");
    }
    
            // Method that creates new Recipe from user iput
    public Recipe createNewRecipe() {  
        
        double totalRecipeCalories = 0;
        
        ArrayList<String> recipeIngredients = new ArrayList<>();
        Ingredient newIngredient = new Ingredient();
        boolean addMoreIngredients = true;
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        setRecipeName(scnr.nextLine());
        
        System.out.println("Please enter the number of servings: ");
        setServings(scnr.nextInt());

        do {

            System.out.println("Would you like to add ingredients? Please type Yes or No");
            String response = scnr.next();

            if (response.toLowerCase().equals("yes")) {
                
                newIngredient.createNewIngredient();
                recipeIngredients.add(new String (newIngredient.getNameOfIngredient()));
                setRecipeIngredients(recipeIngredients);
                
                double ingredientAmount = newIngredient.getIngredientAmount();
                double ingredientCalories = newIngredient.getNumberCalories();
                
                totalRecipeCalories += ingredientAmount * ingredientCalories;
                setTotalRecipeCalories(totalRecipeCalories);   

            } else {
                addMoreIngredients = false;
            }

            
        
        
        
                       
        /*do { // Continues loop until addMoreIngredients becomes false
            
            System.out.println("Please enter the ingredient name or type end if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;            
            } else {
                recipeIngredients.add(new String(ingredientName));
                setRecipeIngredients(recipeIngredients);

                System.out.println("Please enter the ingredient amount: ");
                double ingredientAmount = scnr.nextDouble();
            
                System.out.println("Please enter the ingredient Calories: ");
                int ingredientCalories = scnr.nextInt();
                
                totalRecipeCalories += ingredientAmount * ingredientCalories;     
                setTotalRecipeCalories(totalRecipeCalories);                     
            }*/               
           
       } while (addMoreIngredients == true);       

        Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        recipe1.printRecipe();
        
       return recipe1;
    }    
}

        // - - - - - Custom Method Pseudocode - - - - -
/*Conversion of ingredient amounts from English to metric (or vice versa)
 * GET measurementType
 *      IF measurementType = "cups"
 *          CALCULATE cups to equivalent metric amount -> variable = metricAmount
 *      ELSE measurementTYpe = "ounces"
 *          CALCULATE ounces to equivalent metric amount -> variable = metricAmount
 * PRINT metricAmount under ingredientAmount
 * 
 */