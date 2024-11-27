package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing the "Grocery" class. Includes positive and negative tests for maximum
 * coverage.
 */
class GroceryTest {

  /**
   * Tests a positive behaviour of the constructor by creating a new grocery and validates the
   * assigned information.
   */
  @Test
  void groceryConstructorTestPositive1() {
    Grocery grocery = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    assertEquals("Milk", grocery.getName());
    assertEquals(1, grocery.getQuantity());
    assertEquals("l", grocery.getUnit());
    assertEquals(20, grocery.getPrice());
    assertEquals(LocalDate.of(2024, 11, 20), grocery.getExpiryDate());
  }

  /**
   * Tests a positive behaviour of the constructor by validating that the constructor throws an
   * exception for a null expiry date.
   */
  @Test
  void groceryConstructorTestPositive2() {
    assertThrows(IllegalArgumentException.class, () ->
        new Grocery("Milk", 1, "l", 20, null), "Expiry date cannot be null");
  }

  /**
   * Tests a positive behaviour of the constructor by validating that the constructor throws an
   * exception for a negative quantity.
   */
  @Test
  void groceryConstructorTestPositive3() {
    assertThrows(IllegalArgumentException.class, () ->
            new Grocery("Milk", -1, "l", 20, LocalDate.of(2024, 11, 20)),
        "Quantity cannot be negative");
  }

  /**
   * Positive test for the setQuantity method by setting the quantity and validating the change.
   */
  @Test
  void setQuantityTestPositive1() {
    Grocery grocery = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    grocery.setQuantity(2);
    assertEquals(2, grocery.getQuantity());
  }

  /**
   * Positive test for the setQuantity method by trying to set a negative quantity and validating
   * that the method throws an exception.
   */
  @Test
  void setQuantityTestPositive2() {
    Grocery grocery = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    assertThrows(IllegalArgumentException.class, () ->
        grocery.setQuantity(-1), "Quantity cannot be negative");
  }

  /**
   * Positive test for the toString method by checking for correct formatting of a new grocery.
   */
  @Test
  void toStringTestPositive() {
    Grocery grocery = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    String expected = "Milk: 1.0 l, price: 20.0kr, Expiry date: 2024-11-20";
    assertEquals(expected, grocery.toString());
  }

  /**
   * Positive test for all get-methods.
   */
  @Test
  void gettersTestPositive() {
    Grocery grocery = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
    assertEquals("Milk", grocery.getName());
    assertEquals(1, grocery.getQuantity());
    assertEquals("l", grocery.getUnit());
    assertEquals(20, grocery.getPrice());
    assertEquals(LocalDate.of(2024, 11, 20), grocery.getExpiryDate());
  }
}