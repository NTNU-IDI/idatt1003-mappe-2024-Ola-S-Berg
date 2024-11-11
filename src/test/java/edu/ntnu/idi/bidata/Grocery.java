package edu.ntnu.idi.bidata;

//Klasse "Grocery" har ansvar for å behandle informasjon om varetypene i kjøleskapet.
public class Grocery {

  private String name;
  private double price;
  private int quantity, expiryDate;

  public Grocery(String name, double price, int quantity, int expiryDate) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getExpiryDate() {
    return expiryDate;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
