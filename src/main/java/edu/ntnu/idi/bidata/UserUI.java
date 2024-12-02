package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.List;

/**
 * Class "UserUI" has the responsibility of testing the "Grocery" class and handle user interface.
 */
public class UserUI {

  private Fridge fridge;
  private CookBook cookBook;

  /**
   * Initializes the system while printing "Initializing system" to indicate that the system is
   * starting.
   */
  public void init() {
    fridge = new Fridge();
    CookBook cookBook = new CookBook();
    System.out.println("Initializing system");
  }

  /**
   * Starts the application by populating the fridge with sample groceries and demonstrates some of
   * the functionality of the "Fridge" class.
   */
  public void start() {
    fridge.registerGrocery(new Grocery("Milk", 500, "ml", 20, LocalDate.of(2024, 12, 20)));
    fridge.registerGrocery(new Grocery("Flour", 300, "g", 5, LocalDate.of(2024, 12, 23)));
    fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 12, 30)));
    fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 40, LocalDate.of(2024, 12, 22)));
    fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 12, 25)));

    System.out.println(fridge);

    Recipe pancakes = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 10, 4);
    pancakes.addIngredient(new Grocery("Milk", 300, "ml", 20, LocalDate.of(2024, 12, 20)));
    pancakes.addIngredient(new Grocery("Flour", 200, "g", 5, LocalDate.of(2024, 12, 23)));

    Recipe waffles = new Recipe("Waffles", "Crispy waffles", "Mix and cook", 15, 4);
    waffles.addIngredient(new Grocery("Milk", 200, "ml", 20, LocalDate.of(2024, 12, 20)));
    waffles.addIngredient(new Grocery("Flour", 100, "g", 5, LocalDate.of(2024, 12, 23)));

    cookBook.addRecipe(pancakes);
    cookBook.addRecipe(waffles);

    List<Recipe> possibleRecipes = cookBook.findAllPossibleRecipes(fridge);
    System.out.println("Recipes you can make:");
    for (Recipe recipe : possibleRecipes) {
      System.out.println(recipe.getName());
    }
  }
}
