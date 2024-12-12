package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class for testing the "Nutrients" class.
 */
class NutrientsTest {

  /**
   * Positive test for initializing nutrients with allowed values.
   */
  @Test
  public void testInitializationPositive() {
    Nutrients nutrients = new Nutrients(250, 10, 5, 35);

    assertEquals(250, nutrients.calories());
    assertEquals(10, nutrients.protein());
    assertEquals(5, nutrients.fat());
    assertEquals(35, nutrients.carbs());
  }

  /**
   * Negative test for creating nutrient values with negative calorie value.
   */
  @Test
  void testCaloriesNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Nutrients(-1, 10, 5, 35);
    });
    assertEquals("Nutrient values cannot be negative", exception.getMessage());
  }

  /**
   * Negative test for creating nutrient values with negative protein value.
   */
  @Test
  void testProteinNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Nutrients(250, -1, 5, 35);
    });
    assertEquals("Nutrient values cannot be negative", exception.getMessage());
  }

  /**
   * Negative test for creating nutrient values with negative fat value.
   */
  @Test
  void testFatNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Nutrients(250, 10, -1, 35);
    });
    assertEquals("Nutrient values cannot be negative", exception.getMessage());
  }

  /**
   * Negative test for creating nutrient values with negative carbs value.
   */
  @Test
  void testCarbsNegative() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Nutrients(250, 10, 5, -1);
    });
    assertEquals("Nutrient values cannot be negative", exception.getMessage());
  }
}