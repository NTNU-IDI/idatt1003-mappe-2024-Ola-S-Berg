package edu.ntnu.idi.bidata;

/**
 * Class "Nutrients" has responsibility for handling information about the nutrients of the
 * recipes.
 */
public record Nutrients(double calories, double protein, double fat, double carbs) {

  /**
   * Constructor for initializing nutrients.
   *
   * @param calories The amount of calories in the recipe.
   * @param protein  The amount of protein in the recipe.
   * @param fat      The amount of fat in the recipe.
   * @param carbs    The amount of carbohydrates in the recipe.
   */
  public Nutrients {
    if (calories < 0 || protein < 0 || fat < 0 || carbs < 0) {
      throw new IllegalArgumentException("Nutrient values cannot be negative");
    }
  }

  /**
   * Get-methods to get information about the nutrients.
   */
  @Override
  public double calories() {
    return calories;
  }

  /**
   * Helper method for the "suggestRecipesByMacronutrient" method. Gets the nutrient value from a
   * recipe based on focus.
   *
   * @param focus The macronutrient to focus on.
   * @return The value of the macronutrient for the recipe.
   */
  public double getNutrientValue(String focus) {
    return switch (focus.toLowerCase()) {
      case "carbs" -> this.carbs();
      case "protein" -> this.protein();
      case "fat" -> this.fat();
      default -> throw new IllegalArgumentException("Invalid macronutrient focus " + focus);
    };
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
