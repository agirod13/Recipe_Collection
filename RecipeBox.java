import java.util.ArrayList; //	Imports ArrayList functionality
import java.util.Scanner;	// Imports Scanner functionality

/**
 * Program creates recipes and stores them inside recipebox.
 * 
 * @author Anthony Girod
 * @version 1.0
 */

public class RecipeBox {
   
    private ArrayList<Recipe> listOfRecipes = new ArrayList<>();		//	Instantiates new Recipe object ArrayList

	
	/** 
	 * @return ArrayList<Recipe>
	 */
	// Accessor Method
	public ArrayList<Recipe> getListOfRecipes() {
		
		return listOfRecipes;

	}
	
	// Mutator Method
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		
		this.listOfRecipes = listOfRecipes;

	}

	// Constructor Method
	public RecipeBox() {
		
		setListOfRecipes(listOfRecipes);

	}

	// Overloaded Constructor Method
	public RecipeBox(ArrayList<Recipe> listOfRecipes) {
		
		setListOfRecipes(listOfRecipes);
	
	}


	//	Method that utilizes Recipe print method to create a new recipe
	public void addNewRecipe() {	
            
		Recipe tempRecipe = new Recipe();		
		tempRecipe.createNewRecipe();
		listOfRecipes.add(tempRecipe);
							
	}

	// Method prints all recipe details
	public void printAllRecipeDetails(String selectedRecipeName) {		
		
		for (int i = 0; i < listOfRecipes.size(); i++) {	
		
			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
				
				listOfRecipes.get(i).printRecipe();
				break;
							
			}			
		}			
	}
	
	// Method prints recipe names; utilizes toString override in Recipe
	public void printAllRecipeNames() {		
            
		for (int j = 0; j < listOfRecipes.size(); j++) { 
			
			System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
		
		}		
	}

	// Method deletes recipe	
	public void deleteRecipe(String selectedRecipeName) {		

		for (int i = 0; i < listOfRecipes.size(); i++) {

			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {

				listOfRecipes.remove(i);						
				
			}
		}	
	}

	// Method converts recipe to Metric
	public void convertToMetric(String selectedRecipeName) {		
		
		for (int i = 0; i < listOfRecipes.size(); i++) {	
		
			if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
				
				listOfRecipes.get(i).printMetricRecipe();
				break;
			
			}
		}	
	}
	
	// Main method

	/**
	 * Asks for users to choose one of 5 options and calls corresponding method to enable action
	 * @param args command-line arguments
	 */
	public static void main(String[] args) { 
    	    		
		RecipeBox myRecipeBox = new RecipeBox();	// Creates new RecipeBox object
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

			} else if (input == 5) {	
            
				System.out.println("Which recipe do you want to convert?\n");
				myRecipeBox.printAllRecipeNames();
                String selectedRecipeName = menuScnr.next();
				myRecipeBox.convertToMetric(selectedRecipeName);
			
			} else {
                
				System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Convert to Metric\n" + "\nPlease select a menu item:");
            
			}			
			
			System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete Recipe\n" + "5. Convert to Metric\n" + "\nPlease select a menu item:");
		
		}        
	}
}
