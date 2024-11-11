package edu.ntnu.idi.bidata;

//Klasse "Grocery" har ansvar for å behandle informasjon om varetypene i kjøleskapet.
//
public class Grocery {

  private String name;
  private double price;
  private int quantity;

  public Grocery(String name, double price, int quantity) {
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

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
