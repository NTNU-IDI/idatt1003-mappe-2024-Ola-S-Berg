package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Class "UserUI" has the responsibility of testing the "Grocery" class and handle user interface.
 */
public class UserUI {

  private Fridge fridge;

  /**
   * Initializes the system while printing "Initializing system" to indicate that the system is
   * starting.
   */
  public void init() {
    fridge = new Fridge();
    System.out.println("Initializing system");
  }


  /**
   * Starts the testing of the "Grocery" class by making instances of each grocery, showing them and
   * catching eventual errors in the code, like undefined expiry date or quantity.
   */
  public void start() {
    System.out.println("Testing class 'Grocery'");

    //Positive tests:
    try {
      Grocery milk = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
      Grocery butter = new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 11, 30));

      System.out.println("Positive test cases:");
      System.out.println(milk);
      System.out.println(butter);

    } catch (Exception e) {
      System.out.println("Errors: " + e.getMessage());
    }

    //Negative tests:
    try {
      System.out.println("Negative test case:");
      Grocery eggs = new Grocery("Eggs", 6, "pcs", 40, null);
      System.out.println(eggs);
      System.out.println("Error not caught");

    } catch (IllegalArgumentException e) {
      System.out.println("Error in expiryDate caught: " + e.getMessage());
    }

    try {
      System.out.println("Positive test case:");
      Grocery bacon = new Grocery("Bacon", -1, "pcs", 80, LocalDate.of(2024, 11, 25));
      System.out.println(bacon);
      System.out.println("Error not caught");

    } catch (IllegalArgumentException e) {
      System.out.println("Error in quantity caught: " + e.getMessage());
    }
  }
}
