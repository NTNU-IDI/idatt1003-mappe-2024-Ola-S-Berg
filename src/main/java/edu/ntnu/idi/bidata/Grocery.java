package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Klasse "Grocery" har ansvar for å behandle informasjon om varetypene i kjøleskapet.
 */
public class Grocery {

  private final String name;
  private final String unit;
  private final double price;
  private double quantity;
  private final LocalDate expiryDate;

  /**
   * Konstruktør for å initialisere en ingrediens.
   *
   * @param name       Navnet på ingrediensen, datatype "String" da navnet er en tekststreng.
   * @param unit       Måleenheten til ingrediensen, datatype "String" da måleenhetene brukt er
   *                   liter (l), gram (g) eller stykk (stk).
   * @param price      Prisen til ingrediensen, datatype "double" da prisen kan være et flyttall.
   * @param quantity   Mengden av ingrediensen, datatype "double" da mengden kan være et flyttall.
   * @param expiryDate Utløpsdatoen til ingrediensen, "LocalDate" slik at vi kan bruke datoer.
   * @throws IllegalArgumentException Dersom utløpsdatoen er null eller kvantitet er negativ.
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
   * Aksessormetoder for å hente verdiene
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
   * Setter kvantiteten til ingrediensen. Her er det bare nødvendig med mutatormetode for kvantitet
   * da det er bare den informasjonen som vil endre seg ved brukerinput.
   *
   * @param quantity Den nye kvantiteten til ingrediensen.
   * @throws IllegalArgumentException Dersom kvantiteten er negativ.
   */
  public void setQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
    this.quantity = quantity;
  }

  /**
   * Returnere en strengrepresentasjon av ingrediensen slik at den er lesbar i sysout.
   *
   * @return En streng som beskriver ingrediensen i format: "Navn: kvantitet måleenhet, pris: pris
   * kr, utløpsdato: utløpsdato".
   */
  @Override
  public String toString() {
    return name + ": " + quantity + " " + unit + ", price: " + price + "kr, Expiry date: "
        + expiryDate;
  }
}
