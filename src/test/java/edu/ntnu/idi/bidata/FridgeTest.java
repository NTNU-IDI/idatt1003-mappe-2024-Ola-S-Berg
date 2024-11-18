package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class for testing the "Fridge" class. Includes positive and negative tests for maximum coverage.
 */
class FridgeTest {

  private final Fridge fridge = new Fridge(); //Creates a new fridge.

  /**
   * Creates sample groceries for test use.
   */
  public void sampleGroceries() {
    fridge.registerGrocery(new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20)));
    fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 11, 30)));
    fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 40, LocalDate.of(2024, 11, 22)));
    fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 11, 25)));
  }

  /**
   * Tests adding a new grocery.
   */
  @Test
  void registerGroceryPositive1() {
    Grocery apple = new Grocery("Apple", 3, "kg", 30, LocalDate.of(2024, 12, 10));
    fridge.registerGrocery(apple);
    assertEquals(apple, fridge.searchGrocery("Apple"), "Apple should be added to the fridge.");
  }

  /**
   * Tests registering a duplicate grocery by increasing its quantity.
   */
  @Test
  void registerGroceryPositive2() {
    sampleGroceries();
    Grocery duplicateMilk = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    fridge.registerGrocery(duplicateMilk);
    assertEquals(2, fridge.searchGrocery("Milk").getQuantity(), "Milk's quantity should be 2.");
  }

  /**
   * Tests removing a grocery. Positive test for decreasing the quantity of a grocery.
   */
  @Test
  void removeGroceryPositive() {
    sampleGroceries();
    fridge.removeGrocery("Eggs", 2);
    assertEquals(4, fridge.searchGrocery("Eggs").getQuantity(), "Egg's quantity should be 4.");
  }

  /**
   * Tests removing a grocery. Negative test for removal of a grocery that does not exist.
   */
  @Test
  void removeGroceryNegative1() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      fridge.removeGrocery("Test", 1);
    });
    assertEquals("Grocery does not exist", exception.getMessage());
  }

  /**
   * Tests removing a grocery. Negative test for the removal of a grocery when the quantity is too
   * high.
   */
  @Test
  void removeGroceryNegative2() {
    sampleGroceries();
    fridge.removeGrocery("Butter", 550);
    assertNull(fridge.searchGrocery("Butter"), "Butter should be completely removed.");
  }

  /**
   * Tests searching for a grocery. Positive test for finding an existing grocery.
   */
  @Test
  void searchGroceryPositive() {
    sampleGroceries();
    Grocery result = fridge.searchGrocery("Milk");
    assertNotNull(result, "Milk should be found in the fridge.");
    assertEquals("Milk", result.getName(), "Milk should be returned.");
  }

  /**
   * Tests searching for a grocery. Negative test for trying to find a non-existent grocery.
   */
  @Test
  void searchGroceryNegative() {
    sampleGroceries();
    Grocery result = fridge.searchGrocery("Test");
    assertNull(result, "Test grocery should not be found.");
  }

  /**
   * Tests getting expired groceries. Positive test for only finding an expired grocery.
   */
  @Test
  void getExpiredGroceriesPositive() {
    sampleGroceries();
    List<Grocery> expired = fridge.getExpiredGroceries(LocalDate.of(2024, 11, 21));
    assertEquals(1, expired.size(), "Only milk should be found.");
    assertEquals("Milk", expired.get(0).getName(), "Milk should be returned.");
  }

  /**
   * Tests getting expired groceries. Negative test for not finding any groceries before given
   * date.
   */
  @Test
  void getExpiredGroceriesNegative() {
    sampleGroceries();
    List<Grocery> expired = fridge.getExpiredGroceries(LocalDate.of(2024, 11, 19));
    assertTrue(expired.isEmpty(), "No groceries expired before the date.");
  }

  /**
   * Tests sorting groceries. Positive test for checking how many groceries there are in the fridge
   * and sorting the groceries alphabetically in ascending order.
   */
  @Test
  void getSortedGroceriesPositive() {
    sampleGroceries();
    List<Grocery> sortedGroceries = fridge.getSortedGroceries();
    assertEquals(4, sortedGroceries.size(), "There should be 4 groceries in the fridge.");
    assertEquals("Bacon", sortedGroceries.get(0).getName(), "Bacon should come first.");
    assertEquals("Butter", sortedGroceries.get(1).getName(), "Butter should come second.");
    assertEquals("Eggs", sortedGroceries.get(2).getName(), "Eggs should come third.");
    assertEquals("Milk", sortedGroceries.get(3).getName(), "Milk should come fourth.");
  }

  /**
   * Tests sorting groceries. Negative test for cases where the fridge is empty.
   */
  @Test
  void getSortedGroceriesNegative() {
    List<Grocery> sortedGroceries = fridge.getSortedGroceries();
    assertTrue(sortedGroceries.isEmpty(), "List should be empty if the fridge is empty.");
  }
}