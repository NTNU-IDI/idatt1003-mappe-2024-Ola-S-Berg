package edu.ntnu.idi.bidata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.*;

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

  /**
   * Gets the missing ingredients needed to make the recipe, based on available groceries in the
   * fridge.
   *
   * @param fridge A map representing the available groceries in the fridge.
   * @return A map of missing ingredients.
   */
  public Map<String, Double> getMissingIngredients(Fridge fridge) {
    Map<String, Double> missingIngredients = new HashMap<>();

    for (Recipe recipe : recipes) {
      Map<String, Grocery> recipeIngredients = recipe.getIngredients();

      for (Map.Entry<String, Grocery> entry : recipeIngredients.entrySet()) {
        double ingredientQuantity = entry.getValue().getQuantity();
        Grocery fridgeGrocery = fridge.searchGrocery(entry.getKey());
        double fridgeQuantity = fridgeGrocery != null ? fridgeGrocery.getQuantity() : 0.0;

        if (fridgeQuantity < ingredientQuantity) {
          missingIngredients.put(entry.getKey(), ingredientQuantity - fridgeQuantity);
        }
      }
    }
    return missingIngredients;
  }

  /**
   * Method for finding a recipe by name. Functions as a helper method for method
   * "generateShoppingList" in class "UserUI".
   *
   * @param name The name of the recipe.
   * @return The recipe. Returns null if it did not find the recipe.
   */
  public Recipe findRecipeByName(String name) {
    for (Recipe recipe : recipes) {
      if (recipe.getName().equalsIgnoreCase(name)) {
        return recipe;
      }
    }
    return null;
  }

  /**
   * Suggests recipes based on a specific macronutrient focus.
   *
   * @param focus The macronutrient to focus on.
   * @return A list of recipes sorted by the selected macronutrient.
   */
  public List<Recipe> suggestRecipesByMacronutrient(String focus) {
    return recipes.stream()
        .sorted((r1, r2) -> Double.compare(
            r2.getNutrients().getNutrientValue(focus),
            r1.getNutrients().getNutrientValue(focus)
        ))
        .toList();
  }

  /**
   * Returns a string representation of all recipes in the cookbook.
   *
   * @return A string listing all recipes by name.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CookBook:");
    for (Recipe recipe : recipes) {
      sb.append("\n").append(recipe.toString());
    }
    return sb.toString();
  }
}
