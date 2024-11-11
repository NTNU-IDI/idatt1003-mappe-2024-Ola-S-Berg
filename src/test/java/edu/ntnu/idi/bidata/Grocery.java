package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.*;

//Klasse "Grocery" har ansvar for å behandle informasjon om varetypene i kjøleskapet.
public class Grocery {

  private String name, unit;  //Oppretter informasjon "name" og "unit" som datatype String.
  private double price; //Oppretter informasjon "price" som datatype double grunnet desimaltall.
  private int quantity; //Oppretter informasjon "quantity" som datatype int.
  private LocalDate expiryDate; //Oppretter informasjon "expiryDate" som datatype LocalDate.

  //Konstruktør for å initialisere en grocery med de feltene den trenger.
  public Grocery(String name, int quantity, String unit, double price, LocalDate expiryDate) {
    this.name = name;
    this.unit = unit;
    this.price = price;
    this.quantity = quantity;
    this.expiryDate = expiryDate;
  }

  //Aksessormetoder for å hente verdiene.
  public String getName() {
    return name;
  }

  public String getUnit() {
    return unit;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  //Mutatormetoder for å endre verdier som kan være nødvendige å endre senere.
  //Behandler også ugyldige data ved å kaste unntak.
  public void setQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
    this.quantity = quantity;
  }

  public void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    if (expiryDate == null) {
      throw new IllegalArgumentException("Expiry date cannot be null");
    }
    this.expiryDate = expiryDate;
  }

  //Tostring metode med override for å gjøre informasjon lesbar i Sysout.

  @Override
  public String toString() {
    return name + ": " + quantity + " " + unit + ", pris: " + price + "kr, utløpsdato: "
        + expiryDate;
  }
}
