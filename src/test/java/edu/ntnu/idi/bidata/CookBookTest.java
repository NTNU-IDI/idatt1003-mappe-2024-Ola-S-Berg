package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class CookBookTest {

  private final CookBook cookBook = new CookBook();

  /**
   * Creates sample recipes and adds them to the cookbook.
   */
  private void sampleRecipes() {
    Nutrients pancakeNutrients = new Nutrients(350, 12, 10, 50);
    Recipe pancakes = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4,
        pancakeNutrients);
    pancakes.addIngredient(new Grocery("Milk", 300, "ml", 20, LocalDate.of(2024, 12, 15)));
    pancakes.addIngredient(new Grocery("flour", 200, "g", 5, LocalDate.of(2024, 12, 25)));

    Nutrients waffleNutrients = new Nutrients(500, 16, 15, 53);
    Recipe waffles = new Recipe("Waffles", "Crispy waffles", "Mix and bake", 20, 4,
        waffleNutrients);
    waffles.addIngredient(new Grocery("Milk", 500, "ml", 20, LocalDate.of(2024, 12, 15)));
    waffles.addIngredient(new Grocery("flour", 200, "g", 5, LocalDate.of(2024, 12, 25)));

    cookBook.addRecipe(pancakes);
    cookBook.addRecipe(waffles);
  }

  /**
   * Positive test for adding a recipe to the cookbook.
   */
  @Test
  void addRecipePositive() {
    Nutrients pancakeNutrients = new Nutrients(350, 12, 10, 50);
    Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 15, 4,
        pancakeNutrients);

    cookBook.addRecipe(recipe);

    List<Recipe> recipes = cookBook.getAllRecipes();
    assertEquals(1, recipes.size(), "Cookbook should have one recipe");
    assertEquals("Pancakes", recipes.get(0).getName(), "Recipe name mismatch");
  }

  /**
   * Negative test for adding a null recipe to the cookbook.
   */
  @Test
  void addRecipeNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      cookBook.addRecipe(null);
    });
    assertEquals("Recipe cannot be null", exception.getMessage(), "Exception message mismatch");
  }

  /**
   * Positive test for getting all recipes from the cookbook.
   */
  @Test
  void getAllRecipesPositive() {
    sampleRecipes();

    List<Recipe> recipes = cookBook.getAllRecipes();
    assertEquals(2, recipes.size(), "Cookbook should have two recipes");
    assertEquals("Pancakes", recipes.get(0).getName(), "First recipe should be pancakes");
    assertEquals("Waffles", recipes.get(1).getName(), "Second recipe should be waffles");
  }

  /**
   * Positive test for finding all possible recipes with the groceries at hand.
   */
  @Test
  void findAllPossibleRecipesPositive() {
    Fridge fridge = new Fridge();
    fridge.registerGrocery(new Grocery("Milk", 400, "ml", 20, LocalDate.of(2024, 12, 15)));
    fridge.registerGrocery(new Grocery("flour", 200, "g", 5, LocalDate.of(2024, 12, 25)));

    sampleRecipes();

    List<Recipe> possibleRecipes = cookBook.findAllPossibleRecipes(fridge);
    assertEquals(1, possibleRecipes.size(), "Cookbook should find one possible recipe");
    assertEquals("Pancakes", possibleRecipes.get(0).getName(), "Only pancakes should be found");
  }

  /**
   * Negative test for finding all possible recipes with insufficient groceries.
   */
  @Test
  void findAllPossibleRecipesNegative() {
    Fridge fridge = new Fridge();
    fridge.registerGrocery(new Grocery("Milk", 100, "ml", 20, LocalDate.of(2024, 12, 15)));

    sampleRecipes();

    List<Recipe> possibleRecipes = cookBook.findAllPossibleRecipes(fridge);
    assertTrue(possibleRecipes.isEmpty(), "Cookbook should find no possible recipes");
  }
}