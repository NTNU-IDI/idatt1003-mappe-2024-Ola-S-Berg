package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.*;

//Klasse "Grocery" har ansvar for å behandle informasjon om varetypene i kjøleskapet.
public class Grocery {

  private final String name, unit;  //Oppretter informasjon "name" og "unit" som datatype String. String brukes her grunnet at "navn" og "unit" er tekststrenger i koden.
  private final double price; //Oppretter informasjon "price" som datatype double grunnet bruk av desimaltall.
  private double quantity; //Oppretter informasjon "quantity" som datatype double grunnet bruk av desimaltall.
  private final LocalDate expiryDate; //Oppretter informasjon "expiryDate" som datatype LocalDate for å implementere datoer i koden.

  //Konstruktør for å initialisere en grocery med de feltene den trenger.
  //Lagt til for å kaste unntak under negative tester.
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

  public double getQuantity() {
    return quantity;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  //Mutatormetode for å endre verdi som kan være nødvendig å endre senere.
  //Behandler også ugyldige data ved å kaste unntak under endring av verdier.
  //Her er det bare nødvendig å ha "Quantity" som en mutatormetode da det er den verdien som vil endre seg når man lager mat.
  public void setQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
    this.quantity = quantity;
  }

  //Tostring metode med override for å gjøre informasjon lesbar i Sysout.
  @Override
  public String toString() {
    return name + ": " + quantity + " " + unit + ", price: " + price + "kr, Expiry date: "
        + expiryDate;
  }
}
