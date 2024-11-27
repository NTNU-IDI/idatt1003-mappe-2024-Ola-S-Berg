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
  private int servings;
  //private final String nutrients; Add macro nutrients into own class in the future.

  public Recipe(String name, String description, String procedure, int time, int servings) {
    this.name = name;
    this.description = description;
    this.procedure = procedure;
    this.ingredients = new HashMap<>();
    this.time = time;
    this.servings = servings;
    //this.nutrients = nutrients; Add macro nutrients into own class in the future.
  }
}
