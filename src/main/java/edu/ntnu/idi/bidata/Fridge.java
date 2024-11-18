package edu.ntnu.idi.bidata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fridge {

  private final Map<String, Grocery> groceries = new HashMap<>();

  /**
   * Method for adding a new grocery to the fridge.
   *
   * @param grocery The grocery to add.
   */
  public void registerGrocery(Grocery grocery) {
    if (groceries.containsKey(grocery.getName())) {
      Grocery existingGrocery = groceries.get(grocery.getName());
      existingGrocery.setQuantity((int) (grocery.getQuantity() + grocery.getQuantity()));
    } else {
      groceries.put(grocery.getName(), grocery);
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
  public List<Grocery> searchForGroceries(String name) {
    List<Grocery> groceryNames = new ArrayList<>();

    if (groceries.containsKey(name)) {
      groceryNames.add(groceries.get(name));
    }
    return groceryNames;
  }
}
