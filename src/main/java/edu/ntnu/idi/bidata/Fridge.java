package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class "Fridge" functions as the register for the program. It uses a HashMap to register each
 * grocery name, and assigns information to the groceries using an ArrayList. Contains methods for:
 * adding a grocery, removing a grocery, finding the quantity of a grocery, returning groceries that
 * have not expired and returning all groceries as a sorted list.
 */
public class Fridge {

  private final Map<String, Grocery> groceries; // Stores groceries with their names as keys.

  /**
   * Constructs a new grocery register.
   */
  public Fridge() {
    this.groceries = new HashMap<>();
  }

  /**
   * Method for adding a new grocery to the fridge.
   *
   * @param grocery The grocery to add.
   */
  public void registerGrocery(Grocery grocery) {
    String name = grocery.getName();
    if (groceries.containsKey(name)) {
      Grocery existingGrocery = groceries.get(name);
      existingGrocery.setQuantity(existingGrocery.getQuantity() + grocery.getQuantity());
    } else {
      groceries.put(name, grocery);
    }
  }

  /**
   * Removes a quantity of a grocery from the fridge. If the quantity becomes 0 or less, the grocery
   * is removed from the fridge.
   *
   * @param name     The name of the grocery to remove.
   * @param quantity The quantity of the grocery to remove.
   * @throws IllegalArgumentException If the quantity of the grocery is already 0.
   */
  public void removeGrocery(String name, double quantity) {
    Grocery grocery = groceries.get(name);
    if (grocery == null) {
      throw new IllegalArgumentException("Grocery does not exist");
    }

    if (grocery.getQuantity() <= quantity) {
      groceries.remove(name);
    } else {
      grocery.setQuantity((int) (grocery.getQuantity() - quantity));
    }
  }

  /**
   * Searches for a grocery by its name.
   *
   * @param name The name of a grocery.
   * @return Returns the list of names found.
   */
  public Grocery searchGrocery(String name) {
    return groceries.get(name);
  }

  /**
   * Returns all groceries that have not expired.
   *
   * @param date The date to compare the expiry date against.
   * @return Returns the groceries with expiry dates before the date.
   */
  public List<Grocery> getExpiredGroceries(LocalDate date) {
    List<Grocery> Expired = new ArrayList<>();
    for (Grocery grocery : groceries.values()) {
      if (grocery.getExpiryDate().isBefore(date)) {
        Expired.add(grocery);
      }
    }
    return Expired;
  }

  /**
   * Returns all groceries as a sorted list by their names in ascending order.
   *
   * @return A sorted list of groceries by name.
   */
  public List<Grocery> getSortedGroceries() {
    List<Grocery> sortedGroceries = new ArrayList<>(groceries.values());
    sortedGroceries.sort(Comparator.comparing(Grocery::getName));
    return sortedGroceries;
  }

  /**
   * Returns a string representation of all groceries in the register.
   *
   * @return A string listing all groceries.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Fridge:\n");
    for (Grocery grocery : groceries.values()) {
      sb.append(grocery).append("\n");
    }
    return sb.toString();
  }
}
