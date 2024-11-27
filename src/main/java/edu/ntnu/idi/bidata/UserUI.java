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
   * Starts the application by populating the fridge with sample groceries and demonstrates some of
   * the functionality of the "Fridge" class.
   */
  public void start() {
    fridge.registerGrocery(new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20)));
    fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 11, 30)));
    fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 40, LocalDate.of(2024, 11, 22)));
    fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 11, 25)));

    System.out.println(fridge);

    System.out.println("\nRemoving 1 liter of milk:");
    fridge.removeGrocery("Milk", 1);
    System.out.println(fridge);

    System.out.println("\nSearching for butter:");
    Grocery butter = fridge.searchGrocery("Butter");
    System.out.println(butter);

    System.out.println("\nExpired groceries as of 2024-11-20:");
    fridge.getExpiredGroceries(LocalDate.of(2024, 11, 25)).forEach(System.out::println);

    System.out.println("\nSorted list of groceries:");
    fridge.getSortedGroceries().forEach(System.out::println);
  }
}
