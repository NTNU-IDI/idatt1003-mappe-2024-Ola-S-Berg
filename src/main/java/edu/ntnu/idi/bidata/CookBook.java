package edu.ntnu.idi.bidata;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * The "CookBook" class stores and manages the collection of recipes. Allows users to add, retrieve,
 * and search for recipes.
 */
public class CookBook {

  private final List<Recipe> recipes;

  /**
   * Constructs a new cookbook.
   */
  public CookBook() {
    this.recipes = new ArrayList<>();
  }

  /**
   * Method for adding a new recipe.
   *
   * @param recipe The recipe to add.
   * @throws IllegalArgumentException If the recipe is null.
   */
  public void addRecipe(Recipe recipe) {
    if (recipe == null) {
      throw new IllegalArgumentException("Recipe cannot be null");
    }
    recipes.add(recipe);
  }

  /**
   * Returns a list of all the recipes in the cookbook.
   *
   * @return A list of all recipes.
   */
  public List<Recipe> getAllRecipes() {
    return new ArrayList<>(recipes);
  }

  /**
   * Checks if a specific recipe can be made with the groceries in the fridge. Functions as a helper
   * method for "findAllPossibleRecipes".
   *
   * @param recipe The recipe to check.
   * @param fridge The fridge containing the groceries.
   * @return True if the recipe can be made, false otherwise.
   */
  private boolean canMakeRecipe(Recipe recipe, Fridge fridge) {
    for (Map.Entry<String, Grocery> ingredient : recipe.getIngredients().entrySet()) {
      Grocery fridgeGrocery = fridge.searchGrocery(ingredient.getKey());
      if (fridgeGrocery == null || fridgeGrocery.getQuantity() < ingredient.getValue()
          .getQuantity()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Finds all possible recipes that can be made using the groceries in the fridge.
   *
   * @param fridge The fridge containing the available groceries.
   * @return The list of recipes that can be made.
   */
  public List<Recipe> findAllPossibleRecipes(Fridge fridge) {
    List<Recipe> allPossibleRecipes = new ArrayList<>();
    for (Recipe recipe : recipes) {
      if (canMakeRecipe(recipe, fridge)) {
        allPossibleRecipes.add(recipe);
      }
    }
    return allPossibleRecipes;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CookBook:");
    for (Recipe recipe : recipes) {
      sb.append("\n").append(recipe.toString());
    }
    return sb.toString();
  }
}
