package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RecipeTest {

  /**
   * Positive test for creating a recipe with valid inputs.
   */
  @Test
  void createRecipePositive() {
    Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4);

    assertEquals("Pancakes", recipe.getName(), "Recipe name mismatch");
    assertEquals("Fluffy pancakes", recipe.getDescription(), "Recipe description mismatch");
    assertEquals("Mix and fry", recipe.getProcedure(), "Recipe ingredient mismatch");
    assertEquals(15, recipe.getTime(), "Recipe time mismatch");
    assertEquals(4, recipe.getServings(), "Recipe servings mismatch");
  }

  /**
   * Negative test for creating a recipe with servings <= 0.
   */
  @Test
  void createRecipeNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 0);
    });
    assertEquals("Servings must be greater than 0", exception.getMessage(),
        "Exception message mismatch");
  }

  /**
   * Positive test for adding a valid ingredient.
   */
  @Test
  void addIngredientPositive() {
    Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4);
    Grocery milk = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 12, 15));

    recipe.addIngredient(milk);
    Map<String, Grocery> ingredients = recipe.getIngredients();

    assertEquals(1, ingredients.size(), "Should be one ingredient");
    assertTrue(ingredients.containsKey("Milk"), "Milk should be present in ingredients");
    assertEquals(1, ingredients.get("Milk").getQuantity(), "Milk quantity mismatch");
  }

  /**
   * Negative test for adding a null ingredient to a recipe.
   */
  @Test
  void addIngredientNegative() {
    Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      recipe.addIngredient(null);
    });

    assertEquals("Grocery cannot be null", exception.getMessage(), "Exception message mismatch");
  }

  /**
   * Positive test for getting all ingredients from a recipe.
   */
  @Test
  void getIngredientsPositive() {
    Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4);
    Grocery milk = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 12, 15));
    Grocery flour = new Grocery("Flour", 200, "g", 5, LocalDate.of(2024, 12, 25));

    recipe.addIngredient(milk);
    recipe.addIngredient(flour);

    Map<String, Grocery> ingredients = recipe.getIngredients();

    assertEquals(2, ingredients.size(), "Should be two ingredients");
    assertTrue(ingredients.containsKey("Milk"), "Milk should be present in ingredients");
    assertTrue(ingredients.containsKey("Flour"), "Flour should be present in ingredients");
  }
}