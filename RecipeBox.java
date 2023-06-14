import java.util.ArrayList; //	Imports ArrayList functionality
import java.util.Scanner;	// Imports Scanner functionality

public class RecipeBox {
   
    private ArrayList<Recipe> listOfRecipes = new ArrayList<>();

	// - - - - - Accessor Method
	public ArrayList<Recipe> getListOfRecipes() {
		
		return listOfRecipes;

	}

	// - - - - - Mutator Method
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		
		this.listOfRecipes = listOfRecipes;

	}

	// - - - - - Constructor Method
	public RecipeBox() {
		
		setListOfRecipes(listOfRecipes);

	}

	// - - - - - Overloaded Constructor Method
	public RecipeBox(ArrayList<Recipe> listOfRecipes) {
		
		setListOfRecipes(listOfRecipes);
	
	}

	public void addNewRecipe() {	//	Method that utilizes Recipe print method to create a new recipe
            
		Recipe tempRecipe = new Recipe();		
		tempRecipe.createNewRecipe();
		listOfRecipes.add(tempRecipe);
							
	}

	public void printAllRecipeDetails(String selectedRecipeName) {		// Method prints all recipe details after checking to be sure that recipe exists
			
		for (int i = 0; i < listOfRecipes.size(); i++) {	
		
			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
				
				listOfRecipes.get(i).printRecipe();
			
			} else {

				System.out.println("Recipe not available");

			}
		}
	}
	
	public void printAllRecipeNames() {		//	Method prints recipe names; utilizes toString override in Recipe
            
		for (int j = 0; j < listOfRecipes.size(); j++) { 
			
			System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
		
		}		
	}

	public void deleteRecipe(String selectedRecipeName) {		// Method deletes recipe

		
		for (int i = 0; i < listOfRecipes.size(); i++) {

			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {

				listOfRecipes.remove(i);
			
			} else {

				System.out.println("That's not a valid recipe name");

			}
		}
	
	}

	public void convertToMetric(String selectedRecipeName) {		// Method deletes recipe

		
		for (int i = 0; i < listOfRecipes.size(); i++) {

			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {

				
			
			} else {

				System.out.println("That's not a valid recipe name");

			}
		}
	
	}
	
	
	public static void main(String[] args) { // Creates a Recipe Box
    	    		
		RecipeBox myRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);	
		
		System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Convert to Metric\n" + "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {	//	Continues loop while input remains an integer
            
            int input = menuScnr.nextInt();
		
			if (input == 1) {				
				
				myRecipeBox.addNewRecipe();
        	
			} else if (input == 2) {
                
				System.out.println("Which recipe?\n");
				myRecipeBox.printAllRecipeNames();
                String selectedRecipeName = menuScnr.next();
				myRecipeBox.printAllRecipeDetails(selectedRecipeName);
            
			} else if (input == 3) {		
				
				myRecipeBox.printAllRecipeNames();

			} else if (input == 4) {
				
				System.out.println("Which recipe do you want to delete?\n");
				myRecipeBox.printAllRecipeNames();
                String selectedRecipeName = menuScnr.next();
				myRecipeBox.deleteRecipe(selectedRecipeName);

			/* } else if (input == 5) {	
            
				System.out.println("Which recipe do you want to convert?\n");
				myRecipeBox.printAllRecipeNames();
                String selectedRecipeName = menuScnr.next();
				myRecipeBox.deleteRecipe(selectedRecipeName);
				myRecipeBox.convertToMetric();*/
			
			} else {
                
				System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Convert to Metric\n" + "\nPlease select a menu item:");
            }			
			
			System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Convert to Metric\n" + "\nPlease select a menu item:");
		}
		
        
	}

}
