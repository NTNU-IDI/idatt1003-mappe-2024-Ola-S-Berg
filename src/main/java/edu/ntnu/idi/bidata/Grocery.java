package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Class "Grocery" has responsibility for handling information about the grocery types in the
 * fridge.
 */
public class Grocery {

  private final String name;
  private final String unit;
  private final double price;
  private double quantity;
  private final LocalDate expiryDate;

  /**
   * Constructor for initializing an ingredient.
   *
   * @param name       Name of the ingredient, datatype "String" because the name is a text string.
   * @param unit       Unit of measurement for the ingredient, datatype "String" because the units
   *                   of measurement used are: liters (l), grams (g) or pieces (pcs)
   * @param price      Price of an ingredient, datatype "double" because the price can be a float
   *                   value.
   * @param quantity   Amount of an ingredient, datatype "double" because the amount can be a float
   *                   value.
   * @param expiryDate Expiry date for an ingredient, datatype "LocalDate" to give the expiry date
   *                   an actual date value.
   * @throws IllegalArgumentException If the expiry date is null or the quantity is negative.
   */
  public Grocery(String name, double quantity, String unit, double price, LocalDate expiryDate) {
    this.name = name;
    this.unit = unit;
    this.price = price;
    this.quantity = quantity;
    this.expiryDate = expiryDate;

    if (expiryDate == null) {
      throw new IllegalArgumentException("Expiry date cannot be null");
    }
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
  }

  /**
   * Get-methods to get the values of the ingredients.
   */
  public String getName() {
    return name;
  }

  public String getUnit() {
    return unit;
  }

  public double getPrice() {
    return price;
  }

  public double getQuantity() {
    return quantity;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  /**
   * Sets the quantity of an ingredient. It is only necessary with a set-method for quantity because
   * it is the only information about an ingredient that will change through user input.
   *
   * @param quantity The new quantity of the ingredient.
   * @throws IllegalArgumentException If the quantity set is negative.
   */
  public void setQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
    this.quantity = quantity;
  }

  /**
   * Returns a string representation of the ingredient so that it is readable in print.
   *
   * @return A string that describes the ingredient in format: "Name:, quantity, unit of
   * measurement, price:, price, kr, expiry date:, expiry date.
   */
  @Override
  public String toString() {
    return name + ": " + quantity + " " + unit + ", price: " + price + "kr, Expiry date: "
        + expiryDate;
  }
}
