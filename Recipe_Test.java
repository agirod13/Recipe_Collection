import java.util.ArrayList; // Imports ArrayList functionality

public class Recipe_Test {
	
	public static void main(String[] args) {
		
		// Creates new Recipe from user input
		Recipe newRecipe = new Recipe();		
		Recipe addNewRecipe = newRecipe.createNewRecipe();
		
		// Creates a new recipe for Ramen
		Recipe myFirstRecipe = new Recipe();		
		ArrayList<String> recipeIngredientsOne = new ArrayList<String>();
		String ingredientNameOne = "Noodles";
		recipeIngredientsOne.add(new String(ingredientNameOne));
		myFirstRecipe.setRecipeName("Ramen");		// Users mutators for Recipe creation
		myFirstRecipe.setServings(2);
		myFirstRecipe.setRecipeIngredients(recipeIngredientsOne);
		myFirstRecipe.setTotalRecipeCalories(150);

		// Creates a new recipe for Pizza
		ArrayList<String> recipeIngredientsTwo = new ArrayList<String>(); 
		String ingredientNameTwo = "Anchovies";
		recipeIngredientsTwo.add(new String(ingredientNameTwo));		
		Recipe mySecondRecipe = new Recipe("Pizza", 2,
								recipeIngredientsTwo, 300); // Uses overloaded contructor for Recipe creation		
		
		// Prints Ramen recipe with spacing
		System.out.print(" ");
		System.out.print(" ");
		myFirstRecipe.printRecipe();	
		
		// Prints Pizza recipe with spacing		
		System.out.print(" ");
		System.out.print(" ");
		mySecondRecipe.printRecipe();



	}    
}
