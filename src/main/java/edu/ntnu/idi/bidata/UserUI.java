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

  public void start() {
    fridge.registerGrocery(new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20)));
    fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 11, 30)));
    fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 40, LocalDate.of(2024, 11, 22)));
    fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 11, 25)));

  }
}
