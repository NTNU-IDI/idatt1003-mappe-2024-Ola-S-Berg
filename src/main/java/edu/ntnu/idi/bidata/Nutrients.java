package edu.ntnu.idi.bidata;

/**
 * Class "Nutrients" has responsibility for handling information about the nutrients of the
 * recipes.
 */
public class Nutrients {

  private final double calories;
  private final double protein;
  private final double fat;
  private final double carbs;

  /**
   * Constructor for initializing nutrients.
   *
   * @param calories The amount of calories in the recipe.
   * @param protein  The amount of protein in the recipe.
   * @param fat      The amount of fat in the recipe.
   * @param carbs    The amount of carbohydrates in the recipe.
   */
  public Nutrients(double calories, double protein, double fat, double carbs) {
    if (calories < 0 || protein < 0 || fat < 0 || carbs < 0) {
      throw new IllegalArgumentException("Nutrient values cannot be negative");
    }
    this.calories = calories;
    this.protein = protein;
    this.fat = fat;
    this.carbs = carbs;
  }

  /**
   * Get-methods to get information about the nutrients.
   */
  public double getCalories() {
    return calories;
  }

  public double getProtein() {
    return protein;
  }

  public double getFat() {
    return fat;
  }

  public double getCarbs() {
    return carbs;
  }

  /**
   * Helper method for the "suggestRecipesByMacronutrient" method. Gets the nutrient value from a
   * recipe based on focus.
   *
   * @param focus The macronutrient to focus on.
   * @return The value of the macronutrient for the recipe.
   */
  public double getNutrientValue(String focus) {
    switch (focus.toLowerCase()) {
      case "carbs":
        return this.getCarbs();
      case "protein":
        return this.getProtein();
      case "fat":
        return this.getFat();
      default:
        throw new IllegalArgumentException("Invalid macronutrient focus " + focus);
    }
  }

  /**
   * Returns a string representation of the macronutrients.
   *
   * @return A string representation of macronutrients.
   */
  @Override
  public String toString() {
    return "Calories: " + calories + " kcal, Protein:" + protein + "g, Fat: " + fat + " g, Carbs: "
        + carbs + " g";
  }
}
