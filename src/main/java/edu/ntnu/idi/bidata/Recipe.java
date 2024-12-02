package edu.ntnu.idi.bidata;

import java.util.HashMap;
import java.util.Map;

/**
 * Class "Recipe" has responsibility for handling information about the recipes in the cookbook.
 */
public class Recipe {

  private final String name;
  private final String description;
  private final String procedure;
  private final Map<String, Grocery> ingredients;
  private final int time;
  private final int servings;
  //private final String nutrients; Add macro nutrients into own class in the future.

  public Recipe(String name, String description, String procedure, int time, int servings) {
    if (servings <= 0) {
      throw new IllegalArgumentException("Servings must be greater than 0");
    }

    this.name = name;
    this.description = description;
    this.procedure = procedure;
    this.ingredients = new HashMap<>();
    this.time = time;
    this.servings = servings;
    //this.nutrients = nutrients; Add macro nutrients into own class in the future.
  }

  /**
   * Adds a grocery as an ingredient to the recipe.
   *
   * @param grocery The grocery to add.
   * @throws IllegalArgumentException If the grocery is null.
   */
  public void addIngredient(Grocery grocery) {
    if (grocery == null) {
      throw new IllegalArgumentException("Grocery cannot be null");
    }
    ingredients.put(grocery.getName(), grocery);
  }

  /**
   * Get-methods to get the values of the recipes.
   */
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getProcedure() {
    return procedure;
  }

  public Map<String, Grocery> getIngredients() {
    return ingredients;
  }

  public int getTime() {
    return time;
  }

  public int getServings() {
    return servings;
  }

  @Override
  public String toString() {
    return "Recipe [name=" + name + ", description=" + description + ", procedure=" + procedure
        + ", ingredients=" + ingredients + ", time=" + time + ", servings=" + servings + "]";
  }
}
