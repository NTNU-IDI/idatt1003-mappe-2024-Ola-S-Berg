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

  @Override
  public String toString() {
    return "Calories: " + calories + " kcal, Protein:" + protein + "g, Fat: " + fat + " g, Carbs: "
        + carbs + " g";
  }
}
